#include <bits/stdc++.h>
#include <graphics.h>
using namespace std;

void plotLineLow(int x0, int y0, int x1, int y1)
{
  initwindow(1000, 800);
  int x, y, dx, dy, D;
  dx = x1 - x0;
  dy = y1 - y0;
  int yi = 1;

  if (dy < 0)
  {
    yi = -1;
    dy = -dy;
  }
  D = (2 * dy) - dx;
  y = y0;

  for (x = x0; x <= x1; x++)
  {
    putpixel(x, y, WHITE);
    if (D > 0)
    {
      y = y + yi;
      D = D + (2 * (dy - dx));
    }
    else
    {
      D = D + 2 * dy;
    }
  }
  getch();
}

void plotLineHigh(int x0, int y0, int x1, int y1)
{
  initwindow(1000, 800);
  int x, y, dx, dy, D;
  dx = x1 - x0;
  dy = y1 - y0;
  int xi = 1;

  if (dx < 0)
  {
    xi = -1;
    dx = -dx;
  }
  D = (2 * dy) - dx;
  y = y0;

  for (y = y0; y <= y1; y++)
  {
    putpixel(x, y, WHITE);
    if (D > 0)
    {
      x = x + xi;
      D = D + (2 * (dy - dx));
    }
    else
    {
      D = D + 2 * dx;
    }
  }
  getch();
}

int main()
{
  int x1, y1, x2, y2, dx, dy, p;
  cout << "Enter two points: ";
  cin >> x1 >> y1 >> x2 >> y2;

  if (abs(x2 - x1) > abs(y2 - y1))
  {
    if (x1 > x2)
    {
      plotLineLow(x2, y2, x1, y1);
    }
    else
    {
      plotLineLow(x1, y1, x2, y2);
    }
  }
  else
  {
    if (y1 > y2)
    {
      plotLineHigh(x2, y2, x1, y1);
    }
    else
    {
      plotLineHigh(x1, y1, x2, y2);
    }
  }

  getch();
}