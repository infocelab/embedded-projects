<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE eagle SYSTEM "eagle.dtd">
<eagle version="6.5.0">
<drawing>
<settings>
<setting alwaysvectorfont="no"/>
<setting verticaltext="up"/>
</settings>
<grid distance="0.1" unitdist="inch" unit="inch" style="lines" multiple="1" display="no" altdistance="0.01" altunitdist="inch" altunit="inch"/>
<layers>
<layer number="1" name="Top" color="4" fill="1" visible="no" active="no"/>
<layer number="16" name="Bottom" color="1" fill="1" visible="no" active="no"/>
<layer number="17" name="Pads" color="2" fill="1" visible="no" active="no"/>
<layer number="18" name="Vias" color="2" fill="1" visible="no" active="no"/>
<layer number="19" name="Unrouted" color="6" fill="1" visible="no" active="no"/>
<layer number="20" name="Dimension" color="15" fill="1" visible="no" active="no"/>
<layer number="21" name="tPlace" color="7" fill="1" visible="no" active="no"/>
<layer number="22" name="bPlace" color="7" fill="1" visible="no" active="no"/>
<layer number="23" name="tOrigins" color="15" fill="1" visible="no" active="no"/>
<layer number="24" name="bOrigins" color="15" fill="1" visible="no" active="no"/>
<layer number="25" name="tNames" color="7" fill="1" visible="no" active="no"/>
<layer number="26" name="bNames" color="7" fill="1" visible="no" active="no"/>
<layer number="27" name="tValues" color="7" fill="1" visible="no" active="no"/>
<layer number="28" name="bValues" color="7" fill="1" visible="no" active="no"/>
<layer number="29" name="tStop" color="7" fill="3" visible="no" active="no"/>
<layer number="30" name="bStop" color="7" fill="6" visible="no" active="no"/>
<layer number="31" name="tCream" color="7" fill="4" visible="no" active="no"/>
<layer number="32" name="bCream" color="7" fill="5" visible="no" active="no"/>
<layer number="33" name="tFinish" color="6" fill="3" visible="no" active="no"/>
<layer number="34" name="bFinish" color="6" fill="6" visible="no" active="no"/>
<layer number="35" name="tGlue" color="7" fill="4" visible="no" active="no"/>
<layer number="36" name="bGlue" color="7" fill="5" visible="no" active="no"/>
<layer number="37" name="tTest" color="7" fill="1" visible="no" active="no"/>
<layer number="38" name="bTest" color="7" fill="1" visible="no" active="no"/>
<layer number="39" name="tKeepout" color="4" fill="11" visible="no" active="no"/>
<layer number="40" name="bKeepout" color="1" fill="11" visible="no" active="no"/>
<layer number="41" name="tRestrict" color="4" fill="10" visible="no" active="no"/>
<layer number="42" name="bRestrict" color="1" fill="10" visible="no" active="no"/>
<layer number="43" name="vRestrict" color="2" fill="10" visible="no" active="no"/>
<layer number="44" name="Drills" color="7" fill="1" visible="no" active="no"/>
<layer number="45" name="Holes" color="7" fill="1" visible="no" active="no"/>
<layer number="46" name="Milling" color="3" fill="1" visible="no" active="no"/>
<layer number="47" name="Measures" color="7" fill="1" visible="no" active="no"/>
<layer number="48" name="Document" color="7" fill="1" visible="no" active="no"/>
<layer number="49" name="Reference" color="7" fill="1" visible="no" active="no"/>
<layer number="51" name="tDocu" color="7" fill="1" visible="no" active="no"/>
<layer number="52" name="bDocu" color="7" fill="1" visible="no" active="no"/>
<layer number="91" name="Nets" color="2" fill="1" visible="yes" active="yes"/>
<layer number="92" name="Busses" color="1" fill="1" visible="yes" active="yes"/>
<layer number="93" name="Pins" color="2" fill="1" visible="no" active="yes"/>
<layer number="94" name="Symbols" color="4" fill="1" visible="yes" active="yes"/>
<layer number="95" name="Names" color="7" fill="1" visible="yes" active="yes"/>
<layer number="96" name="Values" color="7" fill="1" visible="yes" active="yes"/>
<layer number="97" name="Info" color="7" fill="1" visible="yes" active="yes"/>
<layer number="98" name="Guide" color="6" fill="1" visible="yes" active="yes"/>
</layers>
<schematic xreflabel="%F%N/%S.%C%R" xrefpart="/%S.%C%R">
<libraries>
<library name="switch-dil">
<description>&lt;b&gt;DIL Switches and Code Switches&lt;/b&gt;&lt;p&gt;
&lt;author&gt;Created by librarian@cadsoft.de&lt;/author&gt;</description>
<packages>
<package name="DP-02">
<description>&lt;b&gt;DIL/CODE SWITCH&lt;/b&gt;&lt;p&gt;</description>
<wire x1="-3.302" y1="-3.683" x2="-2.54" y2="-3.683" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="-3.683" x2="2.54" y2="-3.683" width="0.1524" layer="21"/>
<wire x1="3.302" y1="4.953" x2="-3.302" y2="4.953" width="0.1524" layer="21"/>
<wire x1="1.905" y1="1.143" x2="0.635" y2="1.143" width="0.254" layer="51"/>
<wire x1="3.683" y1="1.905" x2="3.683" y2="-1.905" width="0.254" layer="51"/>
<wire x1="-1.778" y1="3.048" x2="3.302" y2="3.048" width="0.1524" layer="51"/>
<wire x1="3.302" y1="-3.683" x2="3.302" y2="3.048" width="0.1524" layer="21"/>
<wire x1="-3.302" y1="4.953" x2="-3.302" y2="3.048" width="0.1524" layer="21"/>
<wire x1="-3.302" y1="2.54" x2="-2.667" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-2.667" y1="-1.397" x2="-2.667" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-2.667" y1="-1.397" x2="-3.302" y2="-1.397" width="0.1524" layer="21"/>
<wire x1="-3.302" y1="2.54" x2="-3.302" y2="-1.397" width="0.1524" layer="21"/>
<wire x1="-3.302" y1="-1.397" x2="-3.302" y2="-3.683" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="-2.794" x2="-2.54" y2="-3.683" width="0.1524" layer="21"/>
<wire x1="-2.54" y1="-2.794" x2="2.54" y2="-2.794" width="0.1524" layer="21"/>
<wire x1="2.54" y1="-2.794" x2="2.54" y2="-3.683" width="0.1524" layer="21"/>
<wire x1="2.54" y1="-3.683" x2="3.302" y2="-3.683" width="0.1524" layer="21"/>
<wire x1="-2.032" y1="3.048" x2="-3.302" y2="3.048" width="0.1524" layer="21"/>
<wire x1="-3.302" y1="3.048" x2="-3.302" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-0.508" y1="4.318" x2="0.508" y2="4.318" width="0.1524" layer="21"/>
<wire x1="3.302" y1="3.048" x2="2.032" y2="3.048" width="0.1524" layer="21"/>
<wire x1="3.302" y1="3.048" x2="3.302" y2="4.953" width="0.1524" layer="21"/>
<pad name="1" x="-2.54" y="-2.54" drill="0.8128" shape="long" rot="R90"/>
<pad name="2" x="2.54" y="-2.54" drill="0.8128" shape="long" rot="R90"/>
<pad name="3" x="2.54" y="3.81" drill="0.8128" shape="long" rot="R90"/>
<pad name="4" x="-2.54" y="3.81" drill="0.8128" shape="long" rot="R90"/>
<text x="-5.334" y="-1.016" size="1.524" layer="21" ratio="10">1</text>
<text x="0.762" y="-2.286" size="1.524" layer="21" ratio="10">2</text>
<text x="-2.159" y="0" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
<text x="-3.302" y="0.127" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<rectangle x1="-0.762" y1="-1.143" x2="0.762" y2="2.286" layer="51"/>
<rectangle x1="-0.762" y1="-1.143" x2="0.762" y2="2.286" layer="51"/>
</package>
</packages>
<symbols>
<symbol name="DIP02">
<wire x1="-1.905" y1="5.08" x2="-1.905" y2="-5.08" width="0.4064" layer="94"/>
<wire x1="-1.905" y1="5.08" x2="4.445" y2="5.08" width="0.4064" layer="94"/>
<wire x1="4.445" y1="-5.08" x2="4.445" y2="5.08" width="0.4064" layer="94"/>
<wire x1="4.445" y1="-5.08" x2="-1.905" y2="-5.08" width="0.4064" layer="94"/>
<wire x1="0.508" y1="-2.54" x2="-0.508" y2="-2.54" width="0.1524" layer="94"/>
<wire x1="-0.508" y1="2.54" x2="0.508" y2="2.54" width="0.1524" layer="94"/>
<wire x1="0.508" y1="2.54" x2="0.508" y2="-2.54" width="0.1524" layer="94"/>
<wire x1="-0.508" y1="-2.54" x2="-0.508" y2="2.54" width="0.1524" layer="94"/>
<wire x1="3.048" y1="-2.54" x2="2.032" y2="-2.54" width="0.1524" layer="94"/>
<wire x1="2.032" y1="2.54" x2="3.048" y2="2.54" width="0.1524" layer="94"/>
<wire x1="3.048" y1="2.54" x2="3.048" y2="-2.54" width="0.1524" layer="94"/>
<wire x1="2.032" y1="-2.54" x2="2.032" y2="2.54" width="0.1524" layer="94"/>
<text x="-2.54" y="-5.08" size="1.778" layer="95" rot="R90">&gt;NAME</text>
<text x="6.985" y="-5.08" size="1.778" layer="96" rot="R90">&gt;VALUE</text>
<text x="-0.254" y="-4.064" size="0.9906" layer="94" ratio="14">1</text>
<text x="2.159" y="-4.064" size="0.9906" layer="94" ratio="14">2</text>
<text x="-0.762" y="3.048" size="0.9906" layer="94" ratio="14">ON</text>
<rectangle x1="-0.254" y1="-2.286" x2="0.254" y2="0" layer="94"/>
<rectangle x1="2.286" y1="-2.286" x2="2.794" y2="0" layer="94"/>
<pin name="3" x="2.54" y="7.62" visible="pad" length="short" direction="pas" rot="R270"/>
<pin name="4" x="0" y="7.62" visible="pad" length="short" direction="pas" rot="R270"/>
<pin name="1" x="0" y="-7.62" visible="pad" length="short" direction="pas" rot="R90"/>
<pin name="2" x="2.54" y="-7.62" visible="pad" length="short" direction="pas" rot="R90"/>
</symbol>
</symbols>
<devicesets>
<deviceset name="DP02" prefix="S" uservalue="yes">
<description>&lt;b&gt;DIL/CODE SWITCH&lt;/b&gt;</description>
<gates>
<gate name="1" symbol="DIP02" x="0" y="0"/>
</gates>
<devices>
<device name="" package="DP-02">
<connects>
<connect gate="1" pin="1" pad="1"/>
<connect gate="1" pin="2" pad="2"/>
<connect gate="1" pin="3" pad="3"/>
<connect gate="1" pin="4" pad="4"/>
</connects>
<technologies>
<technology name="">
<attribute name="MF" value="" constant="no"/>
<attribute name="MPN" value="MCDP02" constant="no"/>
<attribute name="OC_FARNELL" value="1255233" constant="no"/>
<attribute name="OC_NEWARK" value="26M1095" constant="no"/>
</technology>
</technologies>
</device>
</devices>
</deviceset>
</devicesets>
</library>
<library name="con-amp-quick">
<description>&lt;b&gt;AMP Connectors, Type QUICK&lt;/b&gt;&lt;p&gt;
&lt;author&gt;Created by librarian@cadsoft.de&lt;/author&gt;</description>
<packages>
<package name="10P">
<description>&lt;b&gt;AMP QUICK CONNECTOR&lt;/b&gt;</description>
<wire x1="-10.541" y1="1.778" x2="-10.414" y2="1.651" width="0.1524" layer="21"/>
<wire x1="-10.414" y1="1.651" x2="-10.16" y2="1.397" width="0.1524" layer="21"/>
<wire x1="-10.16" y1="1.397" x2="-9.906" y2="1.651" width="0.1524" layer="21"/>
<wire x1="-9.906" y1="1.651" x2="-9.779" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-10.414" y1="-2.159" x2="-10.414" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-10.414" y1="-2.286" x2="-12.446" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-9.906" y1="-2.159" x2="-10.414" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="-9.906" y1="-2.159" x2="-9.906" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-12.446" y1="2.54" x2="-12.446" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-12.446" y1="1.778" x2="-12.446" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-12.446" y1="-1.778" x2="-12.446" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-12.446" y1="-1.778" x2="-12.065" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="-10.795" y1="-1.778" x2="-10.795" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-12.065" y1="-1.778" x2="-12.065" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-12.065" y1="-1.27" x2="-10.795" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-10.795" y1="-1.524" x2="-10.795" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-9.525" y1="-1.778" x2="-9.525" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-9.525" y1="-1.524" x2="-9.525" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-10.795" y1="-1.524" x2="-10.414" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-10.414" y1="-1.524" x2="-9.906" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-9.906" y1="-1.524" x2="-9.525" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-12.065" y1="-1.524" x2="-12.446" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-12.065" y1="-1.524" x2="-12.065" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-12.446" y1="-1.524" x2="-12.446" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="-12.446" y1="2.54" x2="-11.684" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-11.684" y1="2.54" x2="-11.684" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-11.176" y1="2.54" x2="-11.176" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-11.176" y1="2.667" x2="-11.684" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-9.144" y1="2.54" x2="-9.144" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-8.636" y1="2.54" x2="-8.636" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-9.906" y1="2.413" x2="-9.906" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-10.414" y1="2.413" x2="-10.414" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-7.366" y1="-2.159" x2="-7.874" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="-7.366" y1="-2.159" x2="-7.366" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-5.334" y1="-2.286" x2="-7.366" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-5.334" y1="1.778" x2="-5.334" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-5.715" y1="-1.778" x2="-5.715" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-6.985" y1="-1.27" x2="-5.715" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-8.255" y1="-1.778" x2="-8.255" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-8.255" y1="-1.524" x2="-8.255" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-6.985" y1="-1.778" x2="-6.985" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-6.985" y1="-1.524" x2="-6.985" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-8.255" y1="-1.524" x2="-7.874" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-7.874" y1="-1.524" x2="-7.366" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-7.366" y1="-1.524" x2="-6.985" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-5.715" y1="-1.524" x2="-5.334" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-5.715" y1="-1.524" x2="-5.715" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-6.604" y1="2.54" x2="-6.604" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-6.096" y1="2.54" x2="-5.334" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-6.096" y1="2.54" x2="-6.096" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-6.096" y1="2.667" x2="-6.604" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-7.366" y1="2.413" x2="-7.366" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-7.366" y1="2.54" x2="-6.604" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-7.366" y1="2.413" x2="-7.874" y2="2.413" width="0.1524" layer="21"/>
<wire x1="-7.874" y1="2.413" x2="-7.874" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-8.636" y1="2.54" x2="-7.874" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-8.636" y1="2.667" x2="-9.144" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-9.906" y1="2.54" x2="-9.144" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-10.414" y1="2.413" x2="-9.906" y2="2.413" width="0.1524" layer="21"/>
<wire x1="-10.414" y1="2.54" x2="-11.176" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-10.541" y1="1.778" x2="-12.446" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-9.779" y1="1.778" x2="-7.874" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-7.874" y1="1.778" x2="-7.366" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-9.906" y1="1.651" x2="-9.906" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-10.414" y1="1.651" x2="-10.414" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-7.874" y1="1.778" x2="-7.874" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-7.366" y1="1.778" x2="-7.366" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-9.525" y1="-1.27" x2="-8.255" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-9.525" y1="-1.778" x2="-10.795" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="-9.906" y1="-2.286" x2="-7.874" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-8.255" y1="-1.778" x2="-6.985" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="-7.874" y1="-2.159" x2="-7.874" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-2.794" y1="-2.159" x2="-2.794" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-2.794" y1="-2.286" x2="-4.826" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-2.286" y1="-2.159" x2="-2.794" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="-2.286" y1="-2.159" x2="-2.286" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-4.826" y1="1.778" x2="-4.826" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-3.175" y1="-1.778" x2="-3.175" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-4.445" y1="-1.778" x2="-4.445" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-4.445" y1="-1.27" x2="-3.175" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-3.175" y1="-1.524" x2="-3.175" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="-1.778" x2="-1.905" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="-1.524" x2="-1.905" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-3.175" y1="-1.524" x2="-2.794" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-2.794" y1="-1.524" x2="-2.286" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-2.286" y1="-1.524" x2="-1.905" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-4.445" y1="-1.524" x2="-4.826" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-4.445" y1="-1.524" x2="-4.445" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-4.826" y1="2.54" x2="-4.064" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-4.064" y1="2.54" x2="-4.064" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-3.556" y1="2.54" x2="-3.556" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-3.556" y1="2.667" x2="-4.064" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-1.524" y1="2.54" x2="-1.524" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-1.016" y1="2.54" x2="-1.016" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-2.286" y1="2.413" x2="-2.286" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-2.794" y1="2.413" x2="-2.794" y2="2.54" width="0.1524" layer="21"/>
<wire x1="10.16" y1="1.397" x2="10.414" y2="1.651" width="0.1524" layer="21"/>
<wire x1="10.414" y1="1.651" x2="10.541" y2="1.778" width="0.1524" layer="21"/>
<wire x1="10.414" y1="-2.159" x2="9.906" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="10.414" y1="-2.159" x2="10.414" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="12.446" y1="-2.286" x2="10.414" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="10.541" y1="1.778" x2="12.446" y2="1.778" width="0.1524" layer="21"/>
<wire x1="12.446" y1="1.778" x2="12.446" y2="2.54" width="0.1524" layer="21"/>
<wire x1="12.446" y1="-1.778" x2="12.446" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="12.446" y1="-1.778" x2="12.065" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="12.446" y1="1.778" x2="12.446" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="12.065" y1="-1.778" x2="12.065" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="10.795" y1="-1.27" x2="12.065" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="9.525" y1="-1.778" x2="9.525" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="9.525" y1="-1.524" x2="9.525" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="10.795" y1="-1.778" x2="10.795" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="10.795" y1="-1.524" x2="10.795" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="9.525" y1="-1.524" x2="9.906" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="9.906" y1="-1.524" x2="10.414" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="10.414" y1="-1.524" x2="10.795" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="12.065" y1="-1.524" x2="12.446" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="12.065" y1="-1.524" x2="12.065" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="12.446" y1="-1.524" x2="12.446" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="11.176" y1="2.54" x2="11.176" y2="2.667" width="0.1524" layer="21"/>
<wire x1="11.684" y1="2.54" x2="12.446" y2="2.54" width="0.1524" layer="21"/>
<wire x1="11.684" y1="2.54" x2="11.684" y2="2.667" width="0.1524" layer="21"/>
<wire x1="11.684" y1="2.667" x2="11.176" y2="2.667" width="0.1524" layer="21"/>
<wire x1="10.414" y1="2.413" x2="10.414" y2="2.54" width="0.1524" layer="21"/>
<wire x1="10.414" y1="2.54" x2="11.176" y2="2.54" width="0.1524" layer="21"/>
<wire x1="10.414" y1="2.413" x2="9.906" y2="2.413" width="0.1524" layer="21"/>
<wire x1="9.906" y1="2.413" x2="9.906" y2="2.54" width="0.1524" layer="21"/>
<wire x1="9.779" y1="1.778" x2="9.906" y2="1.651" width="0.1524" layer="21"/>
<wire x1="9.906" y1="1.651" x2="10.16" y2="1.397" width="0.1524" layer="21"/>
<wire x1="-1.016" y1="2.667" x2="-1.524" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-2.286" y1="2.54" x2="-1.524" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-2.794" y1="2.413" x2="-2.286" y2="2.413" width="0.1524" layer="21"/>
<wire x1="-2.794" y1="2.54" x2="-3.556" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-4.826" y1="1.778" x2="-2.794" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-2.286" y1="1.778" x2="-2.286" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-2.794" y1="1.778" x2="-2.794" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="9.906" y1="1.651" x2="9.906" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="10.414" y1="1.651" x2="10.414" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="-1.778" x2="-3.175" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="9.525" y1="-1.778" x2="10.795" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="9.906" y1="-2.159" x2="9.906" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-7.366" y1="1.778" x2="-5.334" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-2.794" y1="1.778" x2="-2.286" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-5.334" y1="-2.159" x2="-5.334" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-4.826" y1="-2.159" x2="-4.826" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-4.826" y1="-2.159" x2="-5.334" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="-4.445" y1="-1.778" x2="-5.715" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="-4.826" y1="-1.524" x2="-5.334" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-4.826" y1="1.778" x2="-5.334" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-4.826" y1="2.413" x2="-5.334" y2="2.413" width="0.1524" layer="21"/>
<wire x1="-5.334" y1="2.54" x2="-5.334" y2="2.413" width="0.1524" layer="21"/>
<wire x1="-4.826" y1="2.54" x2="-4.826" y2="2.413" width="0.1524" layer="21"/>
<wire x1="-0.254" y1="-2.159" x2="-0.254" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-0.254" y1="-2.286" x2="-2.286" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="0.254" y1="-2.159" x2="-0.254" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="0.254" y1="-2.159" x2="0.254" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-0.635" y1="-1.778" x2="-0.635" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="-1.27" x2="-0.635" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-0.635" y1="-1.524" x2="-0.635" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="0.635" y1="-1.778" x2="0.635" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="0.635" y1="-1.524" x2="0.635" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-0.635" y1="-1.524" x2="-0.254" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-0.254" y1="-1.524" x2="0.254" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="0.254" y1="-1.524" x2="0.635" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="1.016" y1="2.54" x2="1.016" y2="2.667" width="0.1524" layer="21"/>
<wire x1="1.524" y1="2.54" x2="1.524" y2="2.667" width="0.1524" layer="21"/>
<wire x1="0.254" y1="2.413" x2="0.254" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-0.254" y1="2.413" x2="-0.254" y2="2.54" width="0.1524" layer="21"/>
<wire x1="1.524" y1="2.667" x2="1.016" y2="2.667" width="0.1524" layer="21"/>
<wire x1="0.254" y1="2.54" x2="1.016" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-0.254" y1="2.413" x2="0.254" y2="2.413" width="0.1524" layer="21"/>
<wire x1="-0.254" y1="2.54" x2="-1.016" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-2.286" y1="1.778" x2="-0.254" y2="1.778" width="0.1524" layer="21"/>
<wire x1="0.254" y1="1.778" x2="0.254" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-0.254" y1="1.778" x2="-0.254" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="0.635" y1="-1.778" x2="-0.635" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="-0.254" y1="1.778" x2="0.254" y2="1.778" width="0.1524" layer="21"/>
<wire x1="2.286" y1="-2.159" x2="2.286" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="2.286" y1="-2.286" x2="0.254" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="2.794" y1="-2.159" x2="2.286" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="2.794" y1="-2.159" x2="2.794" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="1.905" y1="-1.778" x2="1.905" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="0.635" y1="-1.27" x2="1.905" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="1.905" y1="-1.524" x2="1.905" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="3.175" y1="-1.778" x2="3.175" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="3.175" y1="-1.524" x2="3.175" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="1.905" y1="-1.524" x2="2.286" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="2.286" y1="-1.524" x2="2.794" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="2.794" y1="-1.524" x2="3.175" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="3.556" y1="2.54" x2="3.556" y2="2.667" width="0.1524" layer="21"/>
<wire x1="4.064" y1="2.54" x2="4.064" y2="2.667" width="0.1524" layer="21"/>
<wire x1="2.794" y1="2.413" x2="2.794" y2="2.54" width="0.1524" layer="21"/>
<wire x1="2.286" y1="2.413" x2="2.286" y2="2.54" width="0.1524" layer="21"/>
<wire x1="4.064" y1="2.667" x2="3.556" y2="2.667" width="0.1524" layer="21"/>
<wire x1="2.794" y1="2.54" x2="3.556" y2="2.54" width="0.1524" layer="21"/>
<wire x1="2.286" y1="2.413" x2="2.794" y2="2.413" width="0.1524" layer="21"/>
<wire x1="2.286" y1="2.54" x2="1.524" y2="2.54" width="0.1524" layer="21"/>
<wire x1="0.254" y1="1.778" x2="2.286" y2="1.778" width="0.1524" layer="21"/>
<wire x1="2.794" y1="1.778" x2="2.794" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="2.286" y1="1.778" x2="2.286" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="3.175" y1="-1.778" x2="1.905" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="2.286" y1="1.778" x2="2.794" y2="1.778" width="0.1524" layer="21"/>
<wire x1="4.826" y1="-2.159" x2="4.826" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="4.826" y1="-2.286" x2="2.794" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="5.334" y1="-2.159" x2="4.826" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="5.334" y1="-2.159" x2="5.334" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="4.445" y1="-1.778" x2="4.445" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="3.175" y1="-1.27" x2="4.445" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="4.445" y1="-1.524" x2="4.445" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="5.715" y1="-1.778" x2="5.715" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="5.715" y1="-1.524" x2="5.715" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="4.445" y1="-1.524" x2="4.826" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="4.826" y1="-1.524" x2="5.334" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="5.334" y1="-1.524" x2="5.715" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="6.096" y1="2.54" x2="6.096" y2="2.667" width="0.1524" layer="21"/>
<wire x1="6.604" y1="2.54" x2="6.604" y2="2.667" width="0.1524" layer="21"/>
<wire x1="5.334" y1="2.413" x2="5.334" y2="2.54" width="0.1524" layer="21"/>
<wire x1="4.826" y1="2.413" x2="4.826" y2="2.54" width="0.1524" layer="21"/>
<wire x1="6.604" y1="2.667" x2="6.096" y2="2.667" width="0.1524" layer="21"/>
<wire x1="5.334" y1="2.54" x2="6.096" y2="2.54" width="0.1524" layer="21"/>
<wire x1="4.826" y1="2.413" x2="5.334" y2="2.413" width="0.1524" layer="21"/>
<wire x1="4.826" y1="2.54" x2="4.064" y2="2.54" width="0.1524" layer="21"/>
<wire x1="2.794" y1="1.778" x2="4.826" y2="1.778" width="0.1524" layer="21"/>
<wire x1="5.334" y1="1.778" x2="5.334" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="4.826" y1="1.778" x2="4.826" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="5.715" y1="-1.778" x2="4.445" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="4.826" y1="1.778" x2="5.334" y2="1.778" width="0.1524" layer="21"/>
<wire x1="7.366" y1="-2.159" x2="7.366" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="7.366" y1="-2.286" x2="5.334" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="7.874" y1="-2.159" x2="7.366" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="7.874" y1="-2.159" x2="7.874" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="6.985" y1="-1.778" x2="6.985" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="5.715" y1="-1.27" x2="6.985" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="6.985" y1="-1.524" x2="6.985" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="8.255" y1="-1.778" x2="8.255" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="8.255" y1="-1.524" x2="8.255" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="6.985" y1="-1.524" x2="7.366" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="7.366" y1="-1.524" x2="7.874" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="7.874" y1="-1.524" x2="8.255" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="8.636" y1="2.54" x2="8.636" y2="2.667" width="0.1524" layer="21"/>
<wire x1="9.144" y1="2.54" x2="9.144" y2="2.667" width="0.1524" layer="21"/>
<wire x1="7.874" y1="2.413" x2="7.874" y2="2.54" width="0.1524" layer="21"/>
<wire x1="7.366" y1="2.413" x2="7.366" y2="2.54" width="0.1524" layer="21"/>
<wire x1="9.144" y1="2.667" x2="8.636" y2="2.667" width="0.1524" layer="21"/>
<wire x1="7.874" y1="2.54" x2="8.636" y2="2.54" width="0.1524" layer="21"/>
<wire x1="7.366" y1="2.413" x2="7.874" y2="2.413" width="0.1524" layer="21"/>
<wire x1="7.366" y1="2.54" x2="6.604" y2="2.54" width="0.1524" layer="21"/>
<wire x1="5.334" y1="1.778" x2="7.366" y2="1.778" width="0.1524" layer="21"/>
<wire x1="7.874" y1="1.778" x2="7.874" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="7.366" y1="1.778" x2="7.366" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="8.255" y1="-1.778" x2="6.985" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="7.366" y1="1.778" x2="7.874" y2="1.778" width="0.1524" layer="21"/>
<wire x1="9.144" y1="2.54" x2="9.906" y2="2.54" width="0.1524" layer="21"/>
<wire x1="7.874" y1="1.778" x2="9.779" y2="1.778" width="0.1524" layer="21"/>
<wire x1="8.255" y1="-1.27" x2="9.525" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="9.906" y1="-2.286" x2="7.874" y2="-2.286" width="0.1524" layer="21"/>
<pad name="1" x="-11.43" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="2" x="-8.89" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="3" x="-6.35" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="4" x="-3.81" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="5" x="-1.27" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="7" x="3.81" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="6" x="1.27" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="10" x="11.43" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="8" x="6.35" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="9" x="8.89" y="0" drill="0.9144" shape="long" rot="R90"/>
<text x="-10.922" y="0.9398" size="0.9906" layer="21" ratio="12" rot="R90">1</text>
<text x="-12.446" y="2.9464" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="-12.446" y="-3.8354" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
<rectangle x1="-11.7602" y1="-0.3302" x2="-11.0998" y2="0.3302" layer="51"/>
<rectangle x1="-9.2202" y1="-0.3302" x2="-8.5598" y2="0.3302" layer="51"/>
<rectangle x1="-6.6802" y1="-0.3302" x2="-6.0198" y2="0.3302" layer="51"/>
<rectangle x1="-4.1402" y1="-0.3302" x2="-3.4798" y2="0.3302" layer="51"/>
<rectangle x1="-1.6002" y1="-0.3302" x2="-0.9398" y2="0.3302" layer="51"/>
<rectangle x1="3.4798" y1="-0.3302" x2="4.1402" y2="0.3302" layer="51"/>
<rectangle x1="0.9398" y1="-0.3302" x2="1.6002" y2="0.3302" layer="51"/>
<rectangle x1="11.0998" y1="-0.3302" x2="11.7602" y2="0.3302" layer="51"/>
<rectangle x1="6.0198" y1="-0.3302" x2="6.6802" y2="0.3302" layer="51"/>
<rectangle x1="8.5598" y1="-0.3302" x2="9.2202" y2="0.3302" layer="51"/>
</package>
<package name="05P">
<description>&lt;b&gt;AMP QUICK CONNECTOR&lt;/b&gt;</description>
<wire x1="-4.191" y1="1.778" x2="-4.064" y2="1.651" width="0.1524" layer="21"/>
<wire x1="-4.064" y1="1.651" x2="-3.81" y2="1.397" width="0.1524" layer="21"/>
<wire x1="-3.81" y1="1.397" x2="-3.556" y2="1.651" width="0.1524" layer="21"/>
<wire x1="-3.556" y1="1.651" x2="-3.429" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-4.064" y1="-2.159" x2="-4.064" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-4.064" y1="-2.286" x2="-6.096" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-3.556" y1="-2.159" x2="-4.064" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="-3.556" y1="-2.159" x2="-3.556" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-6.096" y1="2.54" x2="-6.096" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-6.096" y1="1.778" x2="-6.096" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-6.096" y1="-1.778" x2="-6.096" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-6.096" y1="-1.778" x2="-5.715" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="-4.445" y1="-1.778" x2="-4.445" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-5.715" y1="-1.778" x2="-5.715" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-5.715" y1="-1.27" x2="-4.445" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-4.445" y1="-1.524" x2="-4.445" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-3.175" y1="-1.778" x2="-3.175" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-3.175" y1="-1.524" x2="-3.175" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-4.445" y1="-1.524" x2="-4.064" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-4.064" y1="-1.524" x2="-3.556" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-3.556" y1="-1.524" x2="-3.175" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-5.715" y1="-1.524" x2="-6.096" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-5.715" y1="-1.524" x2="-5.715" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-6.096" y1="-1.524" x2="-6.096" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="-6.096" y1="2.54" x2="-5.334" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-5.334" y1="2.54" x2="-5.334" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-4.826" y1="2.54" x2="-4.826" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-4.826" y1="2.667" x2="-5.334" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-2.794" y1="2.54" x2="-2.794" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-2.286" y1="2.54" x2="-2.286" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-3.556" y1="2.413" x2="-3.556" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-4.064" y1="2.413" x2="-4.064" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-1.016" y1="-2.159" x2="-1.524" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="-1.016" y1="-2.159" x2="-1.016" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="1.016" y1="-2.286" x2="-1.016" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="1.016" y1="1.778" x2="1.016" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="0.635" y1="-1.778" x2="0.635" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-0.635" y1="-1.27" x2="0.635" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="-1.778" x2="-1.905" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="-1.524" x2="-1.905" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-0.635" y1="-1.778" x2="-0.635" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-0.635" y1="-1.524" x2="-0.635" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="-1.524" x2="-1.524" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-1.524" y1="-1.524" x2="-1.016" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-1.016" y1="-1.524" x2="-0.635" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="0.635" y1="-1.524" x2="1.016" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="0.635" y1="-1.524" x2="0.635" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-0.254" y1="2.54" x2="-0.254" y2="2.667" width="0.1524" layer="21"/>
<wire x1="0.254" y1="2.54" x2="1.016" y2="2.54" width="0.1524" layer="21"/>
<wire x1="0.254" y1="2.54" x2="0.254" y2="2.667" width="0.1524" layer="21"/>
<wire x1="0.254" y1="2.667" x2="-0.254" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-1.016" y1="2.413" x2="-1.016" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-1.016" y1="2.54" x2="-0.254" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-1.016" y1="2.413" x2="-1.524" y2="2.413" width="0.1524" layer="21"/>
<wire x1="-1.524" y1="2.413" x2="-1.524" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-2.286" y1="2.54" x2="-1.524" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-2.286" y1="2.667" x2="-2.794" y2="2.667" width="0.1524" layer="21"/>
<wire x1="-3.556" y1="2.54" x2="-2.794" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-4.064" y1="2.413" x2="-3.556" y2="2.413" width="0.1524" layer="21"/>
<wire x1="-4.064" y1="2.54" x2="-4.826" y2="2.54" width="0.1524" layer="21"/>
<wire x1="-4.191" y1="1.778" x2="-6.096" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-3.429" y1="1.778" x2="-1.524" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-1.524" y1="1.778" x2="-1.016" y2="1.778" width="0.1524" layer="21"/>
<wire x1="-3.556" y1="1.651" x2="-3.556" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-4.064" y1="1.651" x2="-4.064" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-1.524" y1="1.778" x2="-1.524" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-1.016" y1="1.778" x2="-1.016" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="-3.175" y1="-1.27" x2="-1.905" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="-3.175" y1="-1.778" x2="-4.445" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="-3.556" y1="-2.286" x2="-1.524" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-1.905" y1="-1.778" x2="-0.635" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="-1.524" y1="-2.159" x2="-1.524" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="1.524" y1="1.778" x2="1.524" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="1.905" y1="-1.778" x2="1.905" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="1.905" y1="-1.524" x2="1.524" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="1.905" y1="-1.524" x2="1.905" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="2.286" y1="2.54" x2="2.286" y2="2.667" width="0.1524" layer="21"/>
<wire x1="2.794" y1="2.54" x2="2.794" y2="2.667" width="0.1524" layer="21"/>
<wire x1="3.81" y1="1.397" x2="4.064" y2="1.651" width="0.1524" layer="21"/>
<wire x1="4.064" y1="1.651" x2="4.191" y2="1.778" width="0.1524" layer="21"/>
<wire x1="4.064" y1="-2.159" x2="3.556" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="4.064" y1="-2.159" x2="4.064" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="6.096" y1="-2.286" x2="4.064" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="4.191" y1="1.778" x2="6.096" y2="1.778" width="0.1524" layer="21"/>
<wire x1="6.096" y1="1.778" x2="6.096" y2="2.54" width="0.1524" layer="21"/>
<wire x1="6.096" y1="-1.778" x2="6.096" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="6.096" y1="-1.778" x2="5.715" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="6.096" y1="1.778" x2="6.096" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="5.715" y1="-1.778" x2="5.715" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="4.445" y1="-1.27" x2="5.715" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="3.175" y1="-1.778" x2="3.175" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="3.175" y1="-1.524" x2="3.175" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="4.445" y1="-1.778" x2="4.445" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="4.445" y1="-1.524" x2="4.445" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="3.175" y1="-1.524" x2="3.556" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="3.556" y1="-1.524" x2="4.064" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="4.064" y1="-1.524" x2="4.445" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="5.715" y1="-1.524" x2="6.096" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="5.715" y1="-1.524" x2="5.715" y2="-1.27" width="0.1524" layer="21"/>
<wire x1="6.096" y1="-1.524" x2="6.096" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="4.826" y1="2.54" x2="4.826" y2="2.667" width="0.1524" layer="21"/>
<wire x1="5.334" y1="2.54" x2="6.096" y2="2.54" width="0.1524" layer="21"/>
<wire x1="5.334" y1="2.54" x2="5.334" y2="2.667" width="0.1524" layer="21"/>
<wire x1="5.334" y1="2.667" x2="4.826" y2="2.667" width="0.1524" layer="21"/>
<wire x1="4.064" y1="2.413" x2="4.064" y2="2.54" width="0.1524" layer="21"/>
<wire x1="4.064" y1="2.54" x2="4.826" y2="2.54" width="0.1524" layer="21"/>
<wire x1="4.064" y1="2.413" x2="3.556" y2="2.413" width="0.1524" layer="21"/>
<wire x1="3.556" y1="2.413" x2="3.556" y2="2.54" width="0.1524" layer="21"/>
<wire x1="3.429" y1="1.778" x2="3.556" y2="1.651" width="0.1524" layer="21"/>
<wire x1="3.556" y1="1.651" x2="3.81" y2="1.397" width="0.1524" layer="21"/>
<wire x1="2.794" y1="2.54" x2="3.556" y2="2.54" width="0.1524" layer="21"/>
<wire x1="2.794" y1="2.667" x2="2.286" y2="2.667" width="0.1524" layer="21"/>
<wire x1="1.524" y1="2.54" x2="2.286" y2="2.54" width="0.1524" layer="21"/>
<wire x1="3.556" y1="1.651" x2="3.556" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="4.064" y1="1.651" x2="4.064" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="1.524" y1="-2.286" x2="3.556" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="3.175" y1="-1.778" x2="4.445" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="3.556" y1="-2.159" x2="3.556" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="-1.016" y1="1.778" x2="1.016" y2="1.778" width="0.1524" layer="21"/>
<wire x1="1.524" y1="1.778" x2="3.429" y2="1.778" width="0.1524" layer="21"/>
<wire x1="1.016" y1="-2.159" x2="1.016" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="1.524" y1="-2.159" x2="1.524" y2="-2.286" width="0.1524" layer="21"/>
<wire x1="1.524" y1="-2.159" x2="1.016" y2="-2.159" width="0.1524" layer="21"/>
<wire x1="1.905" y1="-1.778" x2="0.635" y2="-1.778" width="0.1524" layer="21"/>
<wire x1="1.524" y1="-1.524" x2="1.016" y2="-1.524" width="0.1524" layer="21"/>
<wire x1="1.524" y1="1.778" x2="1.016" y2="1.778" width="0.1524" layer="21"/>
<wire x1="1.524" y1="2.413" x2="1.016" y2="2.413" width="0.1524" layer="21"/>
<wire x1="1.016" y1="2.54" x2="1.016" y2="2.413" width="0.1524" layer="21"/>
<wire x1="1.524" y1="2.54" x2="1.524" y2="2.413" width="0.1524" layer="21"/>
<wire x1="1.905" y1="-1.27" x2="3.175" y2="-1.27" width="0.1524" layer="21"/>
<pad name="1" x="-5.08" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="2" x="-2.54" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="3" x="0" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="4" x="2.54" y="0" drill="0.9144" shape="long" rot="R90"/>
<pad name="5" x="5.08" y="0" drill="0.9144" shape="long" rot="R90"/>
<text x="-4.572" y="0.9398" size="0.9906" layer="21" ratio="12" rot="R90">1</text>
<text x="-6.096" y="2.9464" size="1.27" layer="25" ratio="10">&gt;NAME</text>
<text x="-6.096" y="-3.8354" size="1.27" layer="27" ratio="10">&gt;VALUE</text>
<rectangle x1="-5.4102" y1="-0.3302" x2="-4.7498" y2="0.3302" layer="51"/>
<rectangle x1="-2.8702" y1="-0.3302" x2="-2.2098" y2="0.3302" layer="51"/>
<rectangle x1="-0.3302" y1="-0.3302" x2="0.3302" y2="0.3302" layer="51"/>
<rectangle x1="2.2098" y1="-0.3302" x2="2.8702" y2="0.3302" layer="51"/>
<rectangle x1="4.7498" y1="-0.3302" x2="5.4102" y2="0.3302" layer="51"/>
</package>
</packages>
<symbols>
<symbol name="M10">
<wire x1="1.27" y1="-15.24" x2="-5.08" y2="-15.24" width="0.4064" layer="94"/>
<wire x1="-1.27" y1="-7.62" x2="0" y2="-7.62" width="0.6096" layer="94"/>
<wire x1="-1.27" y1="-10.16" x2="0" y2="-10.16" width="0.6096" layer="94"/>
<wire x1="-1.27" y1="-12.7" x2="0" y2="-12.7" width="0.6096" layer="94"/>
<wire x1="-5.08" y1="12.7" x2="-5.08" y2="-15.24" width="0.4064" layer="94"/>
<wire x1="1.27" y1="-15.24" x2="1.27" y2="12.7" width="0.4064" layer="94"/>
<wire x1="-5.08" y1="12.7" x2="1.27" y2="12.7" width="0.4064" layer="94"/>
<wire x1="-1.27" y1="-2.54" x2="0" y2="-2.54" width="0.6096" layer="94"/>
<wire x1="-1.27" y1="-5.08" x2="0" y2="-5.08" width="0.6096" layer="94"/>
<wire x1="-1.27" y1="0" x2="0" y2="0" width="0.6096" layer="94"/>
<wire x1="-1.27" y1="2.54" x2="0" y2="2.54" width="0.6096" layer="94"/>
<wire x1="-1.27" y1="5.08" x2="0" y2="5.08" width="0.6096" layer="94"/>
<wire x1="-1.27" y1="7.62" x2="0" y2="7.62" width="0.6096" layer="94"/>
<wire x1="-1.27" y1="10.16" x2="0" y2="10.16" width="0.6096" layer="94"/>
<text x="-5.08" y="-17.78" size="1.778" layer="96">&gt;VALUE</text>
<text x="-5.08" y="13.462" size="1.778" layer="95">&gt;NAME</text>
<pin name="1" x="5.08" y="-12.7" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="2" x="5.08" y="-10.16" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="3" x="5.08" y="-7.62" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="4" x="5.08" y="-5.08" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="5" x="5.08" y="-2.54" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="6" x="5.08" y="0" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="7" x="5.08" y="2.54" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="8" x="5.08" y="5.08" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="9" x="5.08" y="7.62" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="10" x="5.08" y="10.16" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
</symbol>
<symbol name="M05">
<wire x1="3.81" y1="-7.62" x2="-2.54" y2="-7.62" width="0.4064" layer="94"/>
<wire x1="1.27" y1="0" x2="2.54" y2="0" width="0.6096" layer="94"/>
<wire x1="1.27" y1="-2.54" x2="2.54" y2="-2.54" width="0.6096" layer="94"/>
<wire x1="1.27" y1="-5.08" x2="2.54" y2="-5.08" width="0.6096" layer="94"/>
<wire x1="-2.54" y1="7.62" x2="-2.54" y2="-7.62" width="0.4064" layer="94"/>
<wire x1="3.81" y1="-7.62" x2="3.81" y2="7.62" width="0.4064" layer="94"/>
<wire x1="-2.54" y1="7.62" x2="3.81" y2="7.62" width="0.4064" layer="94"/>
<wire x1="1.27" y1="5.08" x2="2.54" y2="5.08" width="0.6096" layer="94"/>
<wire x1="1.27" y1="2.54" x2="2.54" y2="2.54" width="0.6096" layer="94"/>
<text x="-2.54" y="-10.16" size="1.778" layer="96">&gt;VALUE</text>
<text x="-2.54" y="8.382" size="1.778" layer="95">&gt;NAME</text>
<pin name="1" x="7.62" y="-5.08" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="2" x="7.62" y="-2.54" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="3" x="7.62" y="0" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="4" x="7.62" y="2.54" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
<pin name="5" x="7.62" y="5.08" visible="pad" length="middle" direction="pas" swaplevel="1" rot="R180"/>
</symbol>
</symbols>
<devicesets>
<deviceset name="M10" prefix="SL" uservalue="yes">
<description>&lt;b&gt;AMP QUICK CONNECTOR&lt;/b&gt;</description>
<gates>
<gate name="G$1" symbol="M10" x="-2.54" y="0"/>
</gates>
<devices>
<device name="" package="10P">
<connects>
<connect gate="G$1" pin="1" pad="1"/>
<connect gate="G$1" pin="10" pad="10"/>
<connect gate="G$1" pin="2" pad="2"/>
<connect gate="G$1" pin="3" pad="3"/>
<connect gate="G$1" pin="4" pad="4"/>
<connect gate="G$1" pin="5" pad="5"/>
<connect gate="G$1" pin="6" pad="6"/>
<connect gate="G$1" pin="7" pad="7"/>
<connect gate="G$1" pin="8" pad="8"/>
<connect gate="G$1" pin="9" pad="9"/>
</connects>
<technologies>
<technology name="">
<attribute name="MF" value="" constant="no"/>
<attribute name="MPN" value="" constant="no"/>
<attribute name="OC_FARNELL" value="unknown" constant="no"/>
<attribute name="OC_NEWARK" value="unknown" constant="no"/>
</technology>
</technologies>
</device>
</devices>
</deviceset>
<deviceset name="M05" prefix="SL" uservalue="yes">
<description>&lt;b&gt;AMP QUICK CONNECTOR&lt;/b&gt;</description>
<gates>
<gate name="G$1" symbol="M05" x="-2.54" y="0"/>
</gates>
<devices>
<device name="" package="05P">
<connects>
<connect gate="G$1" pin="1" pad="1"/>
<connect gate="G$1" pin="2" pad="2"/>
<connect gate="G$1" pin="3" pad="3"/>
<connect gate="G$1" pin="4" pad="4"/>
<connect gate="G$1" pin="5" pad="5"/>
</connects>
<technologies>
<technology name="">
<attribute name="MF" value="" constant="no"/>
<attribute name="MPN" value="" constant="no"/>
<attribute name="OC_FARNELL" value="unknown" constant="no"/>
<attribute name="OC_NEWARK" value="unknown" constant="no"/>
</technology>
</technologies>
</device>
</devices>
</deviceset>
</devicesets>
</library>
</libraries>
<attributes>
</attributes>
<variantdefs>
</variantdefs>
<classes>
<class number="0" name="default" width="0" drill="0">
</class>
</classes>
<parts>
<part name="S1" library="switch-dil" deviceset="DP02" device="" value="push switch"/>
<part name="S2" library="switch-dil" deviceset="DP02" device="" value="push switch"/>
<part name="S3" library="switch-dil" deviceset="DP02" device=""/>
<part name="S5" library="switch-dil" deviceset="DP02" device=""/>
<part name="S8" library="switch-dil" deviceset="DP02" device=""/>
<part name="S6" library="switch-dil" deviceset="DP02" device=""/>
<part name="S7" library="switch-dil" deviceset="DP02" device=""/>
<part name="S4" library="switch-dil" deviceset="DP02" device=""/>
<part name="S9" library="switch-dil" deviceset="DP02" device=""/>
<part name="S10" library="switch-dil" deviceset="DP02" device=""/>
<part name="S11" library="switch-dil" deviceset="DP02" device=""/>
<part name="S12" library="switch-dil" deviceset="DP02" device=""/>
<part name="S13" library="switch-dil" deviceset="DP02" device=""/>
<part name="S14" library="switch-dil" deviceset="DP02" device=""/>
<part name="S15" library="switch-dil" deviceset="DP02" device=""/>
<part name="S16" library="switch-dil" deviceset="DP02" device=""/>
<part name="CONNECTOR" library="con-amp-quick" deviceset="M10" device="" value="10pin"/>
<part name="RN10" library="con-amp-quick" deviceset="M05" device="" value="5pin"/>
</parts>
<sheets>
<sheet>
<plain>
</plain>
<instances>
<instance part="S1" gate="1" x="38.1" y="60.96"/>
<instance part="S2" gate="1" x="48.26" y="58.42"/>
<instance part="S3" gate="1" x="60.96" y="58.42"/>
<instance part="S5" gate="1" x="38.1" y="40.64"/>
<instance part="S8" gate="1" x="71.12" y="40.64"/>
<instance part="S6" gate="1" x="48.26" y="40.64"/>
<instance part="S7" gate="1" x="60.96" y="40.64"/>
<instance part="S4" gate="1" x="71.12" y="58.42"/>
<instance part="S9" gate="1" x="38.1" y="22.86"/>
<instance part="S10" gate="1" x="48.26" y="22.86"/>
<instance part="S11" gate="1" x="60.96" y="22.86"/>
<instance part="S12" gate="1" x="71.12" y="22.86"/>
<instance part="S13" gate="1" x="38.1" y="5.08"/>
<instance part="S14" gate="1" x="48.26" y="5.08"/>
<instance part="S15" gate="1" x="60.96" y="5.08"/>
<instance part="S16" gate="1" x="71.12" y="5.08"/>
<instance part="CONNECTOR" gate="G$1" x="-5.08" y="30.48" rot="R180"/>
<instance part="RN10" gate="G$1" x="12.7" y="27.94" rot="R180"/>
</instances>
<busses>
</busses>
<nets>
<net name="N$1" class="0">
<segment>
<pinref part="S1" gate="1" pin="2"/>
<wire x1="40.64" y1="53.34" x2="45.72" y2="50.8" width="0.1524" layer="91"/>
<wire x1="45.72" y1="50.8" x2="45.72" y2="55.88" width="0.1524" layer="91"/>
<pinref part="S2" gate="1" pin="2"/>
<wire x1="45.72" y1="55.88" x2="50.8" y2="55.88" width="0.1524" layer="91"/>
<wire x1="50.8" y1="55.88" x2="50.8" y2="50.8" width="0.1524" layer="91"/>
<wire x1="50.8" y1="50.8" x2="55.88" y2="50.8" width="0.1524" layer="91"/>
<wire x1="55.88" y1="50.8" x2="55.88" y2="55.88" width="0.1524" layer="91"/>
<wire x1="55.88" y1="55.88" x2="63.5" y2="55.88" width="0.1524" layer="91"/>
<wire x1="40.64" y1="53.34" x2="40.64" y2="55.88" width="0.1524" layer="91"/>
<wire x1="40.64" y1="55.88" x2="15.24" y2="55.88" width="0.1524" layer="91"/>
<wire x1="15.24" y1="55.88" x2="15.24" y2="50.8" width="0.1524" layer="91"/>
<pinref part="CONNECTOR" gate="G$1" pin="1"/>
<wire x1="15.24" y1="50.8" x2="-5.08" y2="50.8" width="0.1524" layer="91"/>
<wire x1="-5.08" y1="50.8" x2="-10.16" y2="43.18" width="0.1524" layer="91"/>
<wire x1="68.58" y1="55.88" x2="73.66" y2="55.88" width="0.1524" layer="91"/>
<wire x1="68.58" y1="50.8" x2="68.58" y2="55.88" width="0.1524" layer="91"/>
<pinref part="S3" gate="1" pin="2"/>
<wire x1="63.5" y1="50.8" x2="68.58" y2="50.8" width="0.1524" layer="91"/>
<pinref part="S4" gate="1" pin="2"/>
<wire x1="73.66" y1="55.88" x2="73.66" y2="50.8" width="0.1524" layer="91"/>
<wire x1="63.5" y1="55.88" x2="63.5" y2="50.8" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$2" class="0">
<segment>
<pinref part="S5" gate="1" pin="2"/>
<wire x1="40.64" y1="33.02" x2="43.18" y2="33.02" width="0.1524" layer="91"/>
<wire x1="40.64" y1="33.02" x2="40.64" y2="40.64" width="0.1524" layer="91"/>
<pinref part="CONNECTOR" gate="G$1" pin="2"/>
<wire x1="40.64" y1="40.64" x2="-10.16" y2="40.64" width="0.1524" layer="91"/>
<wire x1="43.18" y1="33.02" x2="43.18" y2="38.1" width="0.1524" layer="91"/>
<pinref part="S6" gate="1" pin="2"/>
<wire x1="43.18" y1="38.1" x2="50.8" y2="38.1" width="0.1524" layer="91"/>
<wire x1="50.8" y1="38.1" x2="50.8" y2="33.02" width="0.1524" layer="91"/>
<wire x1="50.8" y1="33.02" x2="55.88" y2="33.02" width="0.1524" layer="91"/>
<wire x1="55.88" y1="33.02" x2="55.88" y2="38.1" width="0.1524" layer="91"/>
<pinref part="S7" gate="1" pin="2"/>
<wire x1="55.88" y1="38.1" x2="63.5" y2="38.1" width="0.1524" layer="91"/>
<wire x1="63.5" y1="38.1" x2="63.5" y2="33.02" width="0.1524" layer="91"/>
<wire x1="63.5" y1="33.02" x2="68.58" y2="33.02" width="0.1524" layer="91"/>
<wire x1="68.58" y1="33.02" x2="68.58" y2="38.1" width="0.1524" layer="91"/>
<pinref part="S8" gate="1" pin="2"/>
<wire x1="68.58" y1="38.1" x2="73.66" y2="38.1" width="0.1524" layer="91"/>
<wire x1="73.66" y1="38.1" x2="73.66" y2="33.02" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$3" class="0">
<segment>
<pinref part="S9" gate="1" pin="2"/>
<wire x1="40.64" y1="15.24" x2="45.72" y2="15.24" width="0.1524" layer="91"/>
<wire x1="45.72" y1="15.24" x2="45.72" y2="20.32" width="0.1524" layer="91"/>
<pinref part="S10" gate="1" pin="2"/>
<wire x1="45.72" y1="20.32" x2="50.8" y2="20.32" width="0.1524" layer="91"/>
<wire x1="50.8" y1="20.32" x2="50.8" y2="15.24" width="0.1524" layer="91"/>
<wire x1="50.8" y1="15.24" x2="55.88" y2="15.24" width="0.1524" layer="91"/>
<wire x1="55.88" y1="15.24" x2="55.88" y2="22.86" width="0.1524" layer="91"/>
<wire x1="55.88" y1="22.86" x2="63.5" y2="25.4" width="0.1524" layer="91"/>
<pinref part="S11" gate="1" pin="2"/>
<wire x1="63.5" y1="25.4" x2="63.5" y2="15.24" width="0.1524" layer="91"/>
<pinref part="S12" gate="1" pin="2"/>
<wire x1="73.66" y1="20.32" x2="73.66" y2="15.24" width="0.1524" layer="91"/>
<wire x1="68.58" y1="20.32" x2="73.66" y2="20.32" width="0.1524" layer="91"/>
<wire x1="63.5" y1="15.24" x2="68.58" y2="15.24" width="0.1524" layer="91"/>
<wire x1="68.58" y1="15.24" x2="68.58" y2="20.32" width="0.1524" layer="91"/>
<wire x1="40.64" y1="15.24" x2="40.64" y2="27.94" width="0.1524" layer="91"/>
<wire x1="40.64" y1="27.94" x2="30.48" y2="27.94" width="0.1524" layer="91"/>
<wire x1="30.48" y1="27.94" x2="30.48" y2="38.1" width="0.1524" layer="91"/>
<pinref part="CONNECTOR" gate="G$1" pin="3"/>
<wire x1="30.48" y1="38.1" x2="-10.16" y2="38.1" width="0.1524" layer="91"/>
<junction x="-10.16" y="38.1"/>
<junction x="40.64" y="15.24"/>
</segment>
</net>
<net name="N$5" class="0">
<segment>
<pinref part="S1" gate="1" pin="1"/>
<wire x1="38.1" y1="53.34" x2="38.1" y2="48.26" width="0.1524" layer="91"/>
<pinref part="S5" gate="1" pin="4"/>
<wire x1="38.1" y1="48.26" x2="38.1" y2="45.72" width="0.1524" layer="91"/>
<junction x="38.1" y="48.26"/>
</segment>
</net>
<net name="N$6" class="0">
<segment>
<pinref part="S5" gate="1" pin="1"/>
<pinref part="S9" gate="1" pin="4"/>
<wire x1="38.1" y1="33.02" x2="38.1" y2="30.48" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$7" class="0">
<segment>
<pinref part="S9" gate="1" pin="1"/>
<pinref part="S13" gate="1" pin="4"/>
<wire x1="38.1" y1="15.24" x2="38.1" y2="12.7" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$9" class="0">
<segment>
<pinref part="S10" gate="1" pin="4"/>
<wire x1="48.26" y1="30.48" x2="48.26" y2="27.94" width="0.1524" layer="91"/>
<pinref part="S6" gate="1" pin="1"/>
<wire x1="48.26" y1="33.02" x2="48.26" y2="30.48" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$10" class="0">
<segment>
<pinref part="S10" gate="1" pin="1"/>
<wire x1="48.26" y1="15.24" x2="48.26" y2="12.7" width="0.1524" layer="91"/>
<pinref part="S14" gate="1" pin="4"/>
<wire x1="48.26" y1="12.7" x2="48.26" y2="10.16" width="0.1524" layer="91"/>
<junction x="48.26" y="12.7"/>
</segment>
</net>
<net name="N$13" class="0">
<segment>
<pinref part="S11" gate="1" pin="1"/>
<wire x1="60.96" y1="15.24" x2="60.96" y2="12.7" width="0.1524" layer="91"/>
<pinref part="S15" gate="1" pin="4"/>
<wire x1="60.96" y1="12.7" x2="60.96" y2="10.16" width="0.1524" layer="91"/>
<junction x="60.96" y="12.7"/>
</segment>
</net>
<net name="N$14" class="0">
<segment>
<pinref part="S12" gate="1" pin="1"/>
<wire x1="71.12" y1="15.24" x2="71.12" y2="12.7" width="0.1524" layer="91"/>
<pinref part="S16" gate="1" pin="4"/>
<wire x1="71.12" y1="12.7" x2="71.12" y2="10.16" width="0.1524" layer="91"/>
<junction x="71.12" y="12.7"/>
</segment>
</net>
<net name="N$16" class="0">
<segment>
<pinref part="S12" gate="1" pin="4"/>
<wire x1="71.12" y1="30.48" x2="71.12" y2="27.94" width="0.1524" layer="91"/>
<pinref part="S8" gate="1" pin="1"/>
<wire x1="71.12" y1="33.02" x2="71.12" y2="30.48" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$18" class="0">
<segment>
<wire x1="25.4" y1="7.62" x2="25.4" y2="35.56" width="0.1524" layer="91"/>
<pinref part="CONNECTOR" gate="G$1" pin="4"/>
<wire x1="25.4" y1="35.56" x2="-10.16" y2="35.56" width="0.1524" layer="91"/>
<junction x="-10.16" y="35.56"/>
<wire x1="25.4" y1="7.62" x2="40.64" y2="7.62" width="0.1524" layer="91"/>
<wire x1="40.64" y1="7.62" x2="40.64" y2="-2.54" width="0.1524" layer="91"/>
<pinref part="S13" gate="1" pin="2"/>
<wire x1="40.64" y1="-2.54" x2="43.18" y2="-2.54" width="0.1524" layer="91"/>
<wire x1="43.18" y1="-2.54" x2="43.18" y2="2.54" width="0.1524" layer="91"/>
<pinref part="S14" gate="1" pin="2"/>
<wire x1="43.18" y1="2.54" x2="50.8" y2="2.54" width="0.1524" layer="91"/>
<wire x1="50.8" y1="2.54" x2="50.8" y2="-2.54" width="0.1524" layer="91"/>
<wire x1="50.8" y1="-2.54" x2="55.88" y2="-2.54" width="0.1524" layer="91"/>
<wire x1="55.88" y1="-2.54" x2="55.88" y2="2.54" width="0.1524" layer="91"/>
<wire x1="55.88" y1="2.54" x2="63.5" y2="2.54" width="0.1524" layer="91"/>
<wire x1="63.5" y1="2.54" x2="63.5" y2="-2.54" width="0.1524" layer="91"/>
<wire x1="63.5" y1="-2.54" x2="63.5" y2="-5.08" width="0.1524" layer="91"/>
<wire x1="63.5" y1="-5.08" x2="68.58" y2="-5.08" width="0.1524" layer="91"/>
<wire x1="68.58" y1="-5.08" x2="68.58" y2="2.54" width="0.1524" layer="91"/>
<pinref part="S16" gate="1" pin="2"/>
<wire x1="68.58" y1="2.54" x2="73.66" y2="2.54" width="0.1524" layer="91"/>
<wire x1="73.66" y1="2.54" x2="73.66" y2="-2.54" width="0.1524" layer="91"/>
<pinref part="S15" gate="1" pin="2"/>
<junction x="63.5" y="-2.54"/>
<junction x="40.64" y="-2.54"/>
<wire x1="40.64" y1="-5.08" x2="40.64" y2="-2.54" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$19" class="0">
<segment>
<pinref part="S13" gate="1" pin="1"/>
<wire x1="38.1" y1="-2.54" x2="20.32" y2="-2.54" width="0.1524" layer="91"/>
<wire x1="20.32" y1="-2.54" x2="20.32" y2="33.02" width="0.1524" layer="91"/>
<pinref part="CONNECTOR" gate="G$1" pin="5"/>
<wire x1="20.32" y1="33.02" x2="5.08" y2="33.02" width="0.1524" layer="91"/>
<pinref part="RN10" gate="G$1" pin="1"/>
<wire x1="5.08" y1="33.02" x2="-10.16" y2="33.02" width="0.1524" layer="91"/>
<junction x="5.08" y="33.02"/>
</segment>
</net>
<net name="N$20" class="0">
<segment>
<pinref part="S14" gate="1" pin="1"/>
<wire x1="48.26" y1="-2.54" x2="48.26" y2="-7.62" width="0.1524" layer="91"/>
<wire x1="48.26" y1="-7.62" x2="15.24" y2="-7.62" width="0.1524" layer="91"/>
<wire x1="15.24" y1="-7.62" x2="17.78" y2="30.48" width="0.1524" layer="91"/>
<pinref part="RN10" gate="G$1" pin="2"/>
<wire x1="17.78" y1="30.48" x2="5.08" y2="30.48" width="0.1524" layer="91"/>
<pinref part="CONNECTOR" gate="G$1" pin="6"/>
<wire x1="5.08" y1="30.48" x2="-10.16" y2="30.48" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$21" class="0">
<segment>
<pinref part="S15" gate="1" pin="1"/>
<wire x1="60.96" y1="-2.54" x2="60.96" y2="-12.7" width="0.1524" layer="91"/>
<wire x1="60.96" y1="-12.7" x2="5.08" y2="-12.7" width="0.1524" layer="91"/>
<wire x1="5.08" y1="-12.7" x2="5.08" y2="27.94" width="0.1524" layer="91"/>
<pinref part="CONNECTOR" gate="G$1" pin="7"/>
<wire x1="5.08" y1="27.94" x2="-10.16" y2="27.94" width="0.1524" layer="91"/>
<pinref part="RN10" gate="G$1" pin="3"/>
<wire x1="5.08" y1="27.94" x2="10.16" y2="27.94" width="0.1524" layer="91"/>
<junction x="5.08" y="27.94"/>
</segment>
</net>
<net name="N$22" class="0">
<segment>
<pinref part="S16" gate="1" pin="1"/>
<wire x1="71.12" y1="-2.54" x2="71.12" y2="-15.24" width="0.1524" layer="91"/>
<wire x1="71.12" y1="-15.24" x2="2.54" y2="-15.24" width="0.1524" layer="91"/>
<wire x1="2.54" y1="-15.24" x2="2.54" y2="25.4" width="0.1524" layer="91"/>
<pinref part="CONNECTOR" gate="G$1" pin="8"/>
<wire x1="2.54" y1="25.4" x2="-10.16" y2="25.4" width="0.1524" layer="91"/>
<wire x1="2.54" y1="25.4" x2="5.08" y2="25.4" width="0.1524" layer="91"/>
<pinref part="RN10" gate="G$1" pin="4"/>
<wire x1="5.08" y1="25.4" x2="10.16" y2="25.4" width="0.1524" layer="91"/>
<junction x="5.08" y="25.4"/>
</segment>
</net>
<net name="N$23" class="0">
<segment>
<pinref part="RN10" gate="G$1" pin="5"/>
<wire x1="5.08" y1="22.86" x2="10.16" y2="22.86" width="0.1524" layer="91"/>
<junction x="5.08" y="22.86"/>
<pinref part="CONNECTOR" gate="G$1" pin="9"/>
<wire x1="-10.16" y1="22.86" x2="5.08" y2="22.86" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$8" class="0">
<segment>
<pinref part="S2" gate="1" pin="1"/>
<pinref part="S6" gate="1" pin="4"/>
<wire x1="48.26" y1="50.8" x2="48.26" y2="48.26" width="0.1524" layer="91"/>
</segment>
</net>
<net name="N$11" class="0">
<segment>
<pinref part="S3" gate="1" pin="1"/>
<wire x1="60.96" y1="50.8" x2="60.96" y2="48.26" width="0.1524" layer="91"/>
<pinref part="S7" gate="1" pin="4"/>
<wire x1="60.96" y1="48.26" x2="60.96" y2="45.72" width="0.1524" layer="91"/>
<junction x="60.96" y="48.26"/>
</segment>
</net>
<net name="N$12" class="0">
<segment>
<pinref part="S4" gate="1" pin="1"/>
<wire x1="71.12" y1="50.8" x2="71.12" y2="48.26" width="0.1524" layer="91"/>
<pinref part="S8" gate="1" pin="4"/>
<wire x1="71.12" y1="48.26" x2="71.12" y2="45.72" width="0.1524" layer="91"/>
<junction x="71.12" y="48.26"/>
</segment>
</net>
<net name="N$4" class="0">
<segment>
<pinref part="S7" gate="1" pin="1"/>
<pinref part="S11" gate="1" pin="4"/>
<wire x1="60.96" y1="33.02" x2="60.96" y2="30.48" width="0.1524" layer="91"/>
</segment>
</net>
</nets>
</sheet>
</sheets>
</schematic>
</drawing>
</eagle>
