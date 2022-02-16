package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FilterB implements Filters {

    @Override
    public void filterAllBlueprints(Set<Blueprint> blueprints) {
        for (Blueprint blueprint : blueprints) {
            List<Point> points = blueprint.getPoints();
            List<Point> newPoints = segmentPoints(points);
            blueprint.setPoints(newPoints);
        }
    }

    @Override
    public void filterBlueprint(Blueprint blueprint) {
        List<Point> points = blueprint.getPoints();
        List<Point> newPoints = segmentPoints(points);
        blueprint.setPoints(newPoints);
    }

    private List<Point> segmentPoints(List<Point> pts) {
        List<Point> newPts = new ArrayList<>();
        for (int i = 0; i < pts.size(); i++) {
            if (i % 2 == 0) {
                newPts.add(pts.get(i));
            }
        }
        return newPts;
    }
}
