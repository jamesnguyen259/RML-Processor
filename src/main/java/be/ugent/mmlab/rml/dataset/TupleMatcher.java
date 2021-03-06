package be.ugent.mmlab.rml.dataset;

import java.util.ArrayList;
import java.util.List;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;
import org.openrdf.model.Value;
import org.openrdf.rio.helpers.RDFHandlerBase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RML Processor
 *
 * @author mielvandersande
 */
class TupleMatcher extends RDFHandlerBase {

    private List<Statement> statements = new ArrayList<>();
    private Resource s;
    private URI p;
    private Value o;

    public TupleMatcher(Resource s, URI p, Value o, Resource... contexts) {
        this.s = s;
        this.p = p;
        this.o = o;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public void handleStatement(Statement st) {
        if ((this.s == null || this.s.equals(st.getSubject())) && (this.p == null || this.p.equals(st.getPredicate())) && (this.o == null || this.o.equals(st.getObject()))) {
            statements.add(st);
        }
    }
}
