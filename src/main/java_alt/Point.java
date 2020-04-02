public class Point {
    private int x;
    private int y;

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // standard constructors/getters/setters
}

/*
Compiled from "Point.java"
public class Point {
    public Point();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

    public void move(int, int);
    Code:
            0: aload_0
       1: iload_1
       2: putfield      #2                  // Field x:I
            5: aload_0
       6: iload_2
       7: putfield      #3                  // Field y:I
            10: return
}
*/