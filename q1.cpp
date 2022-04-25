#include <stdio.h>
#include <conio.h>
#include <graphics.h>
#include <dos.h>
using namespace std;

void drawLineBesFunctions(int x1, int y1, int x2, int y2)
{
  int dx, dy, p, i;
  dx = x2 - x1;
  dy = y2 - y1;
  p = 2 * dy - dx;
  if (abs(dy) < abs(dx))
  {
    if (x1 > x2)
    {
      swap(x1, x2);
      swap(y1, y2);
    }
    dx = x2 - x1;
    dy = y2 - y1;
    int yi = 1;
    if (dy < 0)
    {
      yi = -1;
      dy = -dy;
    }
    int d = (2 * dy) - dx;
    int y = y1;
    for (int x = x1; x <= x2; x++)
    {
      putpixel(x, y, WHITE);
      if (d > 0)
      {
        y = y + yi;
        d = d + (2 * (dy - dx));
      }
      else
      {
        d = d + 2 * dy;
      }
    }
  }
  else
  {
    if (y1 > y2)
    {
      swap(x1, x2);
      swap(y1, y2);
    }
    dx = x2 - x1;
    dy = y2 - y1;
    int xi = 1;
    if (dx < 0)
    {
      xi = -1;
      dx = -dx;
    }
    int d = (2 * dx) - dy;
    int x = x1;
    for (int y = y1; y <= y2; y++)
    {
      putpixel(x, y, WHITE);
      if (d > 0)
      {
        x = x + xi;
        d = d + (2 * (dx - dy));
      }
      else
      {
        d = d + 2 * dx;
      }
    }
  }
}

void Ellipse(int rx, int ry, int xc, int yc)
{
  float dx, dy, d1, d2, x, y;
  x = 0;
  y = ry;
  d1 = (ry * ry) - (rx * rx * ry) + (0.25 * rx * rx);
  dx = 2 * ry * ry * x;
  dy = 2 * rx * rx * y;

  while (dx < dy)
  {
    putpixel(x + xc, y + yc, WHITE);
    putpixel(-x + xc, y + yc, WHITE);
    putpixel(x + xc, -y + yc, WHITE);
    putpixel(-x + xc, -y + yc, WHITE);
    if (d1 < 0)
    {
      x++;
      dx = dx + (2 * ry * ry);
      d1 = d1 + dx + (ry * ry);
    }
    else
    {
      x++;
      y--;
      dx = dx + (2 * ry * ry);
      dy = dy - (2 * rx * rx);
      d1 = d1 + dx - dy + (ry * ry);
    }
  }
  d2 = ((ry * ry)((x + 0.5)(x + 0.5))) + ((rx * rx)((y - 1)(y - 1))) - (rx * rx * ry * ry);
  while (y >= 0)
  {
    putpixel(x + xc, y + yc, WHITE);
    putpixel(-x + xc, y + yc, WHITE);
    putpixel(x + xc, -y + yc, WHITE);
    putpixel(-x + xc, -y + yc, WHITE);
    if (d2 > 0)
    {
      y--;
      dy = dy - (2 * rx * rx);
      d2 = d2 + (rx * rx) - dy;
    }
    else
    {
      y--;
      x++;
      dx = dx + (2 * ry * ry);
      dy = dy - (2 * rx * rx);
      d2 = d2 + dx - dy + (rx * rx);
    }
  }
}

int main()
{
  int gd = DETECT, gm;
  initgraph(&gd, &gm, NULL);

  // 1
  drawLineBesFunctions(60, 100, 60, 250);
  drawLineBesFunctions(35, 125, 60, 100);
  // 1
  drawLineBesFunctions(140, 100, 140, 250);
  drawLineBesFunctions(115, 125, 140, 100);
  // 1
  drawLineBesFunctions(220, 100, 220, 250);
  drawLineBesFunctions(195, 125, 220, 100);
  // 9
  drawLineBesFunctions(300, 100, 300, 175);
  drawLineBesFunctions(300, 175, 350, 175);
  drawLineBesFunctions(300, 100, 350, 100);
  drawLineBesFunctions(300, 250, 350, 250);
  drawLineBesFunctions(350, 100, 350, 250);
  // 1
  drawLineBesFunctions(430, 100, 430, 250);
  drawLineBesFunctions(405, 125, 430, 100);
  // 5
  drawLineBesFunctions(500, 100, 550, 100);
  drawLineBesFunctions(500, 100, 500, 175);
  drawLineBesFunctions(500, 175, 550, 175);
  drawLineBesFunctions(550, 175, 550, 250);
  drawLineBesFunctions(500, 250, 550, 250);
  // 1
  drawLineBesFunctions(600, 100, 600, 250);
  drawLineBesFunctions(575, 125, 600, 100);
  // 1
  drawLineBesFunctions(600, 100, 600, 250);
  drawLineBesFunctions(575, 125, 600, 100);
  // 8
  drawLineBesFunctions(800, 100, 800, 250);
  drawLineBesFunctions(870, 100, 870, 250);
  drawLineBesFunctions(800, 100, 870, 100);
  drawLineBesFunctions(800, 175, 870, 175);
  drawLineBesFunctions(800, 250, 870, 250);

  getch();
  closegraph();
  return 0;
}