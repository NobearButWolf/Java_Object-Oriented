    /*
     * @Author:2017110342_吴谭波
     * @Description:实现四种方法对直线的构造
     * @Date: 2019/10/16
     * @Modified By:2017110342_吴谭波
     */

package tanbo.wu.data.line;

public class Line2D {
    private double A;
    private double B;
    private double C;
    public Line2D(double a,double b,double c){ //一般式
        A = a;
        B = b;
        C = c;
    }
    public Line2D(Point2D point, double slope){  //点斜式
        if(Double.isInfinite(slope) || Double.isNaN(slope)){
            System.out.println("The slope is infinite or none value!");
        }
        else {
            A = slope;
            B = -1;
            C = point.getY() - slope * point.getX();
        }
    }
    public Line2D(Point2D point1,Point2D point2){  //两点式
        if(!point1.equals(point2)){
            A = point1.getY()-point2.getY();
            B = point2.getX()-point2.getX();
            C = point2.getY()*(point1.getX()-point2.getX())-point2.getX()*(point1.getY()-point2.getY());
        }
        else { //两点重合无法唯一确定一条直线
            System.out.println("These two points are the same!");
            System.exit(0);
        }
    }
    public Line2D(double interceptX,double interceptY){  //截距式
        A = 1/interceptX;
        B = 1/interceptY;
        C = -1;
    }

    public boolean isParallel(Line2D anotherLine){
        return A * anotherLine.B == B * anotherLine.A && C != anotherLine.C;
    }
}
