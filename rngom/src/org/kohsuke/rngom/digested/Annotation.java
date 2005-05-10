package org.kohsuke.rngom.digested;

import org.kohsuke.rngom.ast.builder.Annotations;
import org.kohsuke.rngom.ast.builder.BuildException;
import org.kohsuke.rngom.ast.builder.CommentList;
import org.kohsuke.rngom.ast.om.Location;
import org.kohsuke.rngom.ast.om.ParsedElementAnnotation;
import org.xml.sax.Locator;

import javax.xml.namespace.QName;

/**
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
class Annotation implements Annotations {

    private final DAnnotation a = new DAnnotation();

    public void addAttribute(String ns, String localName, String prefix, String value, Location loc) throws BuildException {
        a.attributes.put(new QName(ns,localName,prefix),
            new DAnnotation.Attribute(ns,localName,prefix,value,(Locator)loc));
    }

    public void addElement(ParsedElementAnnotation ea) throws BuildException {
        a.contents.add(((ElementWrapper)ea).element);
    }

    public void addComment(CommentList comments) throws BuildException {
    }

    public void addLeadingComment(CommentList comments) throws BuildException {
    }

    DAnnotation getResult() {
        return a;
    }
}
