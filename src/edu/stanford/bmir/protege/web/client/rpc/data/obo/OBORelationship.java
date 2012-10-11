package edu.stanford.bmir.protege.web.client.rpc.data.obo;

import edu.stanford.bmir.protege.web.client.rpc.data.primitive.VisualNamedClass;
import edu.stanford.bmir.protege.web.client.rpc.data.primitive.VisualObjectProperty;

import java.io.Serializable;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 17/05/2012
 */
public class OBORelationship implements Serializable, Comparable<OBORelationship> {


    private VisualObjectProperty relation;
    
    private VisualNamedClass value;

    private OBORelationship() {
    }

    public OBORelationship(VisualObjectProperty relation, VisualNamedClass value) {
        this.relation = relation;
        this.value = value;
    }

    public VisualObjectProperty getRelation() {
        return relation;
    }

    public VisualNamedClass getValue() {
        return value;
    }


    public int compareTo(OBORelationship o) {
        int diff = relation.compareTo(o.getRelation());
        if(diff != 0) {
            return diff;
        }
        return value.compareTo(o.getValue());
    }
}
