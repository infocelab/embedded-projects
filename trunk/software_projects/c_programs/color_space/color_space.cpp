
// Name: Colorspace
// Description:This is a simple application that converts an HSL color to an RGB color. For some reason it's all in floating-point, I forget why.
// Inputs:The Hue, Saturation and Luminescence color channels of a given color
// Returns:The Red, Green and Blue channels of the same color

#include <math.h>
#include <conio.h>
#include <iostream.h>

#define min(a,b) (((a)<(b))?(a):(b))
#define max(a,b) (((a)>(b))?(a):(b))
#define bmax 100.0 //Input HSL channel maximum
#define cmax 255.0 //Output color maximum

void HslToRgb(double h, double s, double L, double& r, double& g, double& b) 
{
    h *= cmax*6.0/bmax;
    s *= cmax/bmax;
    L *= cmax/bmax;
    r = min(cmax, max(0.0, fabs(3.0*cmax - fmod(h, 6.0*cmax)) - cmax));
    g = min(cmax, max(0.0, fabs(3.0*cmax - fmod(h + 4.0*cmax, 6.0*cmax)) - cmax));
    b = min(cmax, max(0.0, fabs(3.0*cmax - fmod(h + 2.0*cmax, 6.0*cmax)) - cmax));
    
    if (L > cmax/2) 
    {
        r = (L*2/cmax-1)*(cmax-r) + r;
        g = (L*2/cmax-1)*(cmax-g) + g;
        b = (L*2/cmax-1)*(cmax-b) + b;
    }
    else 
    {
        r *= L*2/cmax;
        g *= L*2/cmax;
        b *= L*2/cmax;
    }
    double ave = (r + g + b)/3.0;
    r = (1.0-s/cmax)*(ave - r) + r;
    g = (1.0-s/cmax)*(ave - g) + g;
    b = (1.0-s/cmax)*(ave - b) + b;
}
int main() 
{
    double h, s, l, r, g, b;
    cout << "Enter a hue, a saturation, and a luminance channel, all from 0-100.\n";
    cin >> h >> s >> l;
    HslToRgb(h, s, l, r, g, b);
    cout << "The equivalent RGB color is " << r << ',' << g << ',' << b << '\n';
    getch();
    return 0;
}


