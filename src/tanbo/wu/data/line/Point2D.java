    /*
     * @Author:2017110342_吴谭波
     * @Description:实现构造平面上一个点的功能
     * @Date: 2019/10/16
     * @Modified By:2017110342_吴谭波
     */

package tanbo.wu.data.line;

public class Point2D {
    private double x,y;
    public Point2D(double param_x,double param_y){
        x = param_x;
        y = param_y;
    }
    public boolean equals(Point2D p) {
        return x == p.x && y == p.y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}
