package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;

import java.util.Set;

public interface Filters {

    public void filterAllBlueprints(Set<Blueprint> blueprints);

    public void filterBlueprint(Blueprint blueprint);


}
