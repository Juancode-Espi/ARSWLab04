package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilterA implements Filters {

    @Override
    public void filterAllBlueprints(Set<Blueprint> blueprints) {
        for(Blueprint bp : blueprints){
            List<Point> newPoints = validatePoints(bp.getPoints());
            bp.setPoints(newPoints);
        }
    }

    @Override
    public void filterBlueprint(Blueprint blueprint) {
        List<Point> newPoints = validatePoints(blueprint.getPoints());
        blueprint.setPoints(newPoints);
    }

    private List<Point> validatePoints(List<Point> points){
        ArrayList<String> newPoints = new ArrayList<>();
        for(Point p : points){
            newPoints.add(p.toString());
        }
        Set<String> hashSetPoints = new HashSet<>(newPoints);
        newPoints.clear();
        newPoints.addAll(hashSetPoints);
        ArrayList<Point> pointArrayList = new ArrayList<>();
        for(String pointC: newPoints){
            Point p = new Point(pointC);
            pointArrayList.add(p);
        }

        return pointArrayList;
    }
}
