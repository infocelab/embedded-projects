/// <summary>
/// 
/// Routines for communicating with USB custom device using mpusbapi.dll
/// 
/// Author : C. V. Niras
/// 
/// This software was written using Visual Studio 2008 Standard Edition using  
/// the .NET Framework V2.0.
/// 
/// Ver 1.0
/// Date : Monday, 15th June, 2009
/// 
/// </summary>

using System;
using System.Runtime.InteropServices;
using System.Windows.Forms;
using System.Collections.Generic;

namespace usbInterface
{
    using DWORD = UInt32;
    using HANDLE = UInt32;

    class MPUSB
    {
        #region  String Definitions of Pipes and VID_PID

        // MAX_NUM_MPUSB_DEV is an abstract limitation.
        // It is very unlikely that a computer system will have more
        // then 127 USB devices attached to it. (single or multiple USB hosts)
        const int MAX_NUM_MPUSB_DEV = 127;
        const HANDLE INVALID_HANDLE_VALUE = 0xFFFFFFFF;
        const int ERROR_INVALID_HANDLE = 6;

        const string vid_pid = @"vid_04d8&pid_000c";                // Default Demo Application Firmware
        const string out_pipe = @"\MCHP_EP1";
        const string in_pipe = @"\MCHP_EP1";

        internal const Int32 DBT_DEVICEARRIVAL = 0x8000;            // system detected a new device
        internal const Int32 DBT_DEVICEQUERYREMOVE = 0x8001;        // wants to remove, may fail
        internal const Int32 DBT_DEVICEQUERYREMOVEFAILED = 0x8002;  // removal aborted
        internal const Int32 DBT_DEVICEREMOVEPENDING = 0x8003;      // about to remove, still avail.
        internal const Int32 DBT_DEVICEREMOVECOMPLETE = 0x8004;     // device is gone
        internal const Int32 DBT_CONFIGCHANGED = 0x0018;
        internal const Int32 DEVICE_NOTIFY_WINDOW_HANDLE = 0x00;

        internal const Int32 DBT_DEVTYP_DEVICEINTERFACE = 0x05;
        internal const Int32 WM_DEVICECHANGE = 0x219;

        [StructLayout(LayoutKind.Sequential)]
        internal class DEV_BROADCAST_DEVICEINTERFACE
        {
            internal Int32 dbcc_size;
            internal Int32 dbcc_devicetype;
            internal Int32 dbcc_reserved;
            internal Guid dbcc_classguid;
            internal Int16 dbcc_name;
        }

        public bool AttachedState = false;

        HANDLE myOutPipe = INVALID_HANDLE_VALUE;
        HANDLE myInPipe = INVALID_HANDLE_VALUE;

        #endregion

        #region Imported DLL functions from mpusbapi.dll

        private enum PipeDir : uint
        {
            Write = 0,
            Read = 1
        }
        [DllImport("user32.dll", CharSet = CharSet.Auto, SetLastError = true)]
        private static extern IntPtr RegisterDeviceNotification(IntPtr hRecipient, IntPtr NotificationFilter, Int32 Flags);

        [DllImport("user32.dll", SetLastError = true)]
        private static extern Boolean UnregisterDeviceNotification(IntPtr Handle);

        [DllImport("mpusbapi.dll", EntryPoint = "_MPUSBGetDLLVersion")]
        private static extern DWORD GetDLLVersion();

        [DllImport("mpusbapi.dll", EntryPoint = "_MPUSBGetDeviceCount")]
        private static extern DWORD GetDeviceCount([MarshalAs(UnmanagedType.LPStr)] string pVID_PID);

        [DllImport("mpusbapi.dll", EntryPoint = "_MPUSBOpen", SetLastError = true)]
        private static extern DWORD Open(DWORD instance,        // Input
           [MarshalAs(UnmanagedType.LPStr)] string pVID_PID,    // Input
           [MarshalAs(UnmanagedType.LPStr)] string pEP,         // Input
              [MarshalAs(UnmanagedType.U4)] PipeDir dwDir,      // Input
                                            DWORD dwReserved);  // Input
        [DllImport("mpusbapi.dll", EntryPoint = "_MPUSBClose")]
        private static extern bool Close(HANDLE handle);        // Input

        [DllImport("mpusbapi.dll", EntryPoint = "_MPUSBRead", SetLastError = true)]
        private static extern DWORD Read(HANDLE handle,         // Input
         [MarshalAs(UnmanagedType.LPArray)] byte[] pData,       // Output
                                            DWORD dwLen,        // Input
                                        out DWORD pLength,      // Output
                                            DWORD dwMilliseconds);  // Input

        [DllImport("mpusbapi.dll", EntryPoint = "_MPUSBWrite", SetLastError = true)]
        private static extern DWORD Write(HANDLE handle,        // Input
         [MarshalAs(UnmanagedType.LPArray)] byte[] pData,       // Output
                                            DWORD dwLen,        // Input
                                        out DWORD pLength,      // Output
                                            DWORD dwMilliseconds);  // Input

        [DllImport("mpusbapi.dll", EntryPoint = "_MPUSBReadInt")]
        private static extern DWORD ReadInt(HANDLE handle,      // Input
         [MarshalAs(UnmanagedType.LPArray)] byte[] pData,       // Output
                                            DWORD dwLen,        // Input
                                        out DWORD pLength,      // Output
                                            DWORD dwMilliseconds);  // Input

        private void OpenPipes()
        {
            // Selects the device to connect to, in this example it is assumed you will only have 
            // one device per vid_pid connected.
            myOutPipe = Open(0, vid_pid, out_pipe, PipeDir.Write, 0);
            myInPipe = Open(0, vid_pid, in_pipe, PipeDir.Read, 0);
        }
        private void ClosePipes()
        {
            Close(myOutPipe);
            Close(myInPipe);
        }
        #endregion

        internal uint SendReceivePacket( byte[] SendData, uint SendLength, byte[] ReceiveData, ref uint ReceiveLength)
        {
            uint SendDelay = 1000;
            uint ReceiveDelay = 1000;

            uint SentDataLength = 0;
            DWORD ExpectedReceiveLength = ReceiveLength;

            if (myOutPipe != INVALID_HANDLE_VALUE && myInPipe != INVALID_HANDLE_VALUE)
            {
                if (Write(myOutPipe, SendData, SendLength, out SentDataLength, SendDelay) > 0)
                {
                    if (Read(myInPipe, ReceiveData, ExpectedReceiveLength, out ReceiveLength, ReceiveDelay) > 0)
                    {
                        if (ExpectedReceiveLength == ReceiveLength)
                        {
                            return (1);
                        }
                        else if (ReceiveLength < ExpectedReceiveLength)
                        {
                            // Partially failed, incorrect receive length
                            MessageBox.Show("Partially failed, incorrect receive length", "Function SendReceivePacket");
                            return (2);
                        }
                    }
                    else
                    {
                        MessageBox.Show("Read Failed", "Function SendReceivePacket");  //Operation Failed
                        CheckInvalidHandle();
                    }
                }
                else
                {
                    MessageBox.Show("Write Failed ", "Function SendReceivePacket");  //Operation Failed
                    CheckInvalidHandle();
                }
            }//if(myOutPipe != INVALID_HANDLE_VALUE && myInPipe != INVALID_HANDLE_VALUE)
            return (0);
        }
        private void CheckInvalidHandle()
        {
            if (Marshal.GetLastWin32Error() == ERROR_INVALID_HANDLE)
            {
                // Most likely cause of the error is the board was disconnected.
                ClosePipes();
                AttachedState = false;
                myOutPipe = myInPipe = INVALID_HANDLE_VALUE;
            }
        }
        internal void OpenUSB()
        {
            List<String> allPorts = new List<String>();
            foreach (String portName in System.IO.Ports.SerialPort.GetPortNames())
            {
                allPorts.Add(portName);
            }
           // return allPorts;
            //if (GetDeviceCount(vid_pid) > 0)
            //{
            //    if (AttachedState == false)
            //    {
            //        // Always open one device only, assumed you will only have one device per vid_pid
            //        myOutPipe = Open(0, vid_pid, out_pipe, PipeDir.Write, 0);
            //        myInPipe = Open(0, vid_pid, in_pipe, PipeDir.Read, 0);
            //        if (myOutPipe == INVALID_HANDLE_VALUE || myInPipe == INVALID_HANDLE_VALUE)
            //        {
            //            AttachedState = false;
            //            MessageBox.Show("Failed to open data pipes", "Function OpenUsb");
            //        }
            //        else
            //        {
            //            AttachedState = true;
            //        }
            //    }
            //}
        }
        internal bool RegisterForDeviceNotification(IntPtr devHandle, ref IntPtr devNotificationHandle)
        {
            //Globally Unique Identifier (GUID). Windows uses GUIDs to identify things.  
            Guid InterfaceClassGuid = new Guid(0xa5dcbf10, 0x6530, 0x11d2, 0x90, 0x1F, 0x00, 0xC0, 0x4F, 0xB9, 0x51, 0xED); //Globally Unique Identifier (GUID) for USB peripheral devices

            // A DEV_BROADCAST_DEVICEINTERFACE header holds information about the request.

            DEV_BROADCAST_DEVICEINTERFACE devBroadcastDeviceInterface = new DEV_BROADCAST_DEVICEINTERFACE();
            IntPtr devBroadcastDeviceInterfaceBuffer = IntPtr.Zero;
            Int32 size = 0;

            try
            {
                // Set the parameters in the DEV_BROADCAST_DEVICEINTERFACE structure.
                // Set the size.
                size = Marshal.SizeOf(devBroadcastDeviceInterface);
                devBroadcastDeviceInterface.dbcc_size = size;
                // Request to receive notifications about a class of devices.
                devBroadcastDeviceInterface.dbcc_devicetype = DBT_DEVTYP_DEVICEINTERFACE;
                devBroadcastDeviceInterface.dbcc_reserved = 0;
                // Specify the interface class to receive notifications about.
                devBroadcastDeviceInterface.dbcc_classguid = InterfaceClassGuid;
                // Allocate memory for the buffer that holds the DEV_BROADCAST_DEVICEINTERFACE structure.
                devBroadcastDeviceInterfaceBuffer = Marshal.AllocHGlobal(size);
                // Copy the DEV_BROADCAST_DEVICEINTERFACE structure to the buffer.
                // Set fDeleteOld True to prevent memory leaks.
                Marshal.StructureToPtr(devBroadcastDeviceInterface, devBroadcastDeviceInterfaceBuffer, true);
                devNotificationHandle = RegisterDeviceNotification(devHandle, devBroadcastDeviceInterfaceBuffer, 0);
                if (devNotificationHandle.ToInt32() == IntPtr.Zero.ToInt32())
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
            catch
            {
                throw;
            }
            finally
            {
                if (devBroadcastDeviceInterfaceBuffer != IntPtr.Zero)
                {
                    // Free the memory allocated previously by AllocHGlobal.
                    Marshal.FreeHGlobal(devBroadcastDeviceInterfaceBuffer);
                }
            }
        }
        ///  <summary>
        ///  Requests to stop receiving notification messages when a device in an
        ///  interface class is attached or removed.
        ///  </summary>
        ///  
        ///  <param name="deviceNotificationHandle"> handle returned previously by
        ///  RegisterDeviceNotification. </param>

        internal void StopReceivingDeviceNotifications(IntPtr deviceNotificationHandle)
        {
            try
            {
                UnregisterDeviceNotification(deviceNotificationHandle);
            }
            catch
            {
                throw;
            }
        }
        internal void OnDeviceChange(Message m)
        {
            if ((m.WParam.ToInt32() == DBT_DEVICEARRIVAL) || (m.WParam.ToInt32() == DBT_DEVICEREMOVEPENDING) || (m.WParam.ToInt32() == DBT_DEVICEREMOVECOMPLETE) || ((int)m.WParam == DBT_CONFIGCHANGED))
            {
                if (GetDeviceCount(vid_pid) > 0)
                {
                    if (AttachedState == false)
                    {
                        OpenUSB();
                    }
                }
                else
                {
                    ClosePipes();
                    AttachedState = false;
                }
            }
        }

    }

}
