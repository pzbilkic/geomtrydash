import java.awt.*;
public class object {

    public void draw(graphics g){

    }

    public void formTraingle_Paint(object sender, Arg0){
        Point [] point = new Point [3];

        point[0].X = 150;
        point[0].Y = 150;
        point[1].Y = 150;
        point[1].Y = 200;
        point[2].Y = 50;
        point[2].Y = 120;

        graphics g.draw(pen_draw, point);
    }

    public void formPlatform_Paint(){//need to pass something in but do not know what
        Point [] point = new Point [4];

        point[0].X = 150;
        point[0].Y = 150;
        point[1].Y = 150;
        point[1].Y = 200;
        point[2].Y = 50;
        point[2].Y = 120;
        point[3].X = 250;
        point[3].Y = 250;
    }
}
