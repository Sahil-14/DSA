#include <GL/glut.h>

GLfloat xRotated, yRotated, zRotated;
GLdouble innerRaidus = 0.5;
GLdouble outterRaidus = 1;
GLint sides = 50;
GLint rings = 50;

void displayTorus(void)
{

  glMatrixMode(GL_MODELVIEW);
  glClear(GL_COLOR_BUFFER_BIT);
  glLoadIdentity();
  glTranslatef(0.0, 0.0, -4.5);
  glColor3f(0.4, 0.2, 0.1);
  glRotatef(xRotated, 1.0, 0.0, 0.0);
  glRotatef(yRotated, 0.0, 1.0, 0.0);
  glRotatef(zRotated, 0.0, 0.0, 1.0);
  glScalef(1.0, 1.0, 1.0);
  glutSolidTorus(innerRaidus, outterRaidus, sides, rings);
  glFlush();
}

void reshapeTorus(int x, int y)
{
  if (y == 0 || x == 0)
    return;
  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  gluPerspective(40.0, (GLdouble)x / (GLdouble)y, 0.5, 20.0);

  glViewport(0, 0, x, y);
}

void idleTorus(void)
{

  yRotated += 0.01;
  displayTorus();
}

int main(int argc, char **argv)
{

  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
  glutInitWindowSize(800, 400);
  glutCreateWindow("3d torus by sahil shimpi (111915108)");
  glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
  xRotated = yRotated = zRotated = 30.0;
  xRotated = 33;
  yRotated = 40;
  glClearColor(0.0, 0.0, 0.0, 0.0);
  glutDisplayFunc(displayTorus);
  glutReshapeFunc(reshapeTorus);
  glutIdleFunc(idleTorus);
  glutMainLoop();
  return 0;
}