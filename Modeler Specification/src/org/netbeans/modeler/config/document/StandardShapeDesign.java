/**
 * Copyright [2014] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.modeler.config.document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.netbeans.modeler.shape.InnerShapeContext;
import org.netbeans.modeler.shape.OuterShapeContext;

@XmlRootElement(name = "shape-design", namespace = "http://nbmodeler.java.net")
@XmlType(name = "shape-design")

@XmlAccessorType(XmlAccessType.FIELD)
public class StandardShapeDesign {

    @XmlElement(name = "outer-shape")

    private OuterShapeContext outerShapeContext;

    @XmlElement(name = "inner-shape")
    private InnerShapeContext innerShapeContext;

    /**
     * @return the outerShapeContext
     */
    public OuterShapeContext getOuterShapeContext() {
        return outerShapeContext;
    }

    /**
     * @param outerShapeContext the outerShapeContext to set
     */
    public void setOuterShapeContext(OuterShapeContext outerShapeContext) {
        this.outerShapeContext = outerShapeContext;
    }

    /**
     * @return the innerShapeContext
     */
    public InnerShapeContext getInnerShapeContext() {
        return innerShapeContext;
    }

    /**
     * @param innerShapeContext the innerShapeContext to set
     */
    public void setInnerShapeContext(InnerShapeContext innerShapeContext) {
        this.innerShapeContext = innerShapeContext;
    }

}
