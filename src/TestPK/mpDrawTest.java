package TestPK;

import Ynu.Sei.cpLibrary.BASIC.cpDraw;
import Ynu.Sei.cpLibrary.DS.kdTree.KeyDuplicateException;
import Ynu.Sei.cpLibrary.DS.kdTree.KeySizeException;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import mondelbrotPicturePK.mondelbrotPicture;
import point2DMatrixPK.mondelbrotPoint;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by lj on 2016/4/19.
 */
public class mpDrawTest {
    Point2D mouse = null;

    public static void main(String[] args) throws KeySizeException, KeyDuplicateException,
            InstantiationException, IllegalAccessException {
        // TODO Auto-generated method stub
        double W, H;
        /*扩大的倍数*/
        int k = 2;
        double minx, maxx;
        double miny, maxy;
        minx = miny = -2;
        maxx = maxy = 2;
        cpDraw.setX(minx, maxx, 0.1);
        cpDraw.setY(miny, maxy, 0.1);
        cpDraw.drawStyle2();
        mondelbrotPicture mpic = new mondelbrotPicture(new Point2D(-0.5, 0), 2, 2, 100, mondelbrotPoint.class);
        mpic.draw();
        while (true) {
            if (cpDraw.mouseClicked() && cpDraw.mouseClickedCount() == 1) {
                cpDraw.clear();
                W = mpic.W();
                H = mpic.H();
                Point2D mouse = new Point2D(cpDraw.mouseX(), cpDraw.mouseY());
                minx = mouse.x() - W / k / 2;
                maxx = mouse.x() + W / k / 2;
                miny = mouse.y() - H / k / 2;
                maxy = mouse.y() + H / k / 2;
                cpDraw.setX(minx, maxx, 0.01);
                cpDraw.setY(miny, maxy, 0.01);
                cpDraw.drawStyle2();
                mpic = new mondelbrotPicture(mouse, W / k, H / k, 100, mondelbrotPoint.class);
                mpic.draw();
                cpDraw.setmouseClickedFalse();
            }
        }
    }

}
