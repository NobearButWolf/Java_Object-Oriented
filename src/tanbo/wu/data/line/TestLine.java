    /*
     * @Author:2017110342_吴谭波
     * @Description:实现判断两条直线是否平行功能的测试
     * @Date: 2019/10/16
     * @Modified By:2017110342_吴谭波
     */

package tanbo.wu.data.line;

import tanbo.wu.data.line.Line2D;
import tanbo.wu.data.line.Point2D;

public class TestLine {
    public static void main(String[] args){
        Point2D p1 = new Point2D(3,4);
        Point2D p2 = new Point2D(-3,7);
        Line2D l1 = new Line2D(2,-1,3);
        Line2D l2 = new Line2D(p1,2);
        Line2D l3 = new Line2D(p1,p2);
        Line2D l4 = new Line2D(2,-4);
        System.out.println("l1 is parallel to l2?" + l1.isParallel(l2));
        System.out.println("l1 is parallel to l3?" + l1.isParallel(l3));
        System.out.println("l1 is parallel to l4?" + l1.isParallel(l4));
        System.out.println("l2 is parallel to l3?" + l2.isParallel(l3));
        System.out.println("l2 is parallel to l4?" + l2.isParallel(l4));
        System.out.println("l3 is parallel to l4?" + l3.isParallel(l4));
    }
}
