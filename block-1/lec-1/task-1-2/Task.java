static int x = 0;

static int r_y = 0;
static int r_z = 0;

class A extends Thread {
    public void run() {
        int y = -1;       // A.1
        int a_x = x;      // A.2
        if (a_x == 0) {   // A.3
            y = x;          // A.4
            x = y + 1;      // A.5
        }
        r_y = y;           // A.6
    }
}

class B extends Thread {
    public void run() {
        int z = -1;       // B.1
        int b_x = x;      // B.2
        if (b_x == 0) {   // B.3
            z = x;          // B.4
            x = z + 1;      // B.5
        }
        r_z = z;            // B.6
    }
}