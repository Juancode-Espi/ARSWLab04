package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.filters.FilterA;
import edu.eci.arsw.blueprints.filters.Filters;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

public class Application {

    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices services = ac.getBean(BlueprintsServices.class);
        Point[] points = new Point[]{new Point(2,2),new Point(3,5),new Point(2,2)};
        Blueprint mockBlueprint = new Blueprint("Descartes","Discurso del metodo",points);
        Blueprint book2 = new Blueprint("Descartes","Meditaciones metafisicas");
        book2.addPoint(new Point(31,2));
        book2.addPoint(new Point(31,2));
        try {
            services.addNewBlueprint(mockBlueprint);
            services.addNewBlueprint(book2);
            Set<Blueprint> blueprintSet = services.getBlueprintsByAuthor("Descartes");
            Filters filter = new FilterA();
            filter.filterAllBlueprints(blueprintSet);
            for(Blueprint bp : blueprintSet){
                System.out.println(bp.toString());
                for(Point p : bp.getPoints()){
                    System.out.println(p.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
