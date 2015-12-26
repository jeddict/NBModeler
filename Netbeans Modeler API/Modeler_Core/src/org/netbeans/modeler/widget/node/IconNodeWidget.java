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
package org.netbeans.modeler.widget.node;

import org.netbeans.api.visual.laf.LookFeel;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.model.ObjectState;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.modeler.specification.model.document.IModelerScene;
import org.netbeans.modeler.widget.node.image.NodeImageWidget;

/**
 *
 *
 */
public class IconNodeWidget extends Widget {


    /**
     * @param labelWidget the labelWidget to set
     */
//    public void setLabelWidget(LabelWidget labelWidget) {
//        this.labelWidget = labelWidget;
//    }
    /**
     * Returns the label widget part of the icon node widget.
     *
     * @return the label widget
     */
//    public LabelWidget getLabelWidget () {
//        return labelWidget;
//    }
    public static enum TextOrientation {

        BOTTOM_CENTER, RIGHT_CENTER

    }

    private NodeImageWidget nodeImageWidget;
//    private LabelWidget labelWidget;

    /**
     * Creates an icon node widget with bottom-center orientation.
     *
     * @param scene the scene
     */
    public IconNodeWidget(IModelerScene scene) {
        this(scene, TextOrientation.BOTTOM_CENTER);
    }

    /**
     * Creates an icon node widget with a specified orientation.
     *
     * @param scene the scene
     * @param orientation the text orientation
     */
    public IconNodeWidget(IModelerScene scene, TextOrientation orientation) {
        super((Scene) scene);
        LookFeel lookFeel = getScene().getLookFeel();

        switch (orientation) {
            case BOTTOM_CENTER:
                setLayout(LayoutFactory.createVerticalFlowLayout(LayoutFactory.SerialAlignment.CENTER, -lookFeel.getMargin() + 1));
                break;
            case RIGHT_CENTER:
                setLayout(LayoutFactory.createHorizontalFlowLayout(LayoutFactory.SerialAlignment.CENTER, -lookFeel.getMargin() + 1));
                break;
        }

        setState(ObjectState.createNormal());

    }

    /**
     * Implements the widget-state specific look of the widget.
     *
     * @param previousState the previous state
     * @param state the new state
     */
    @Override
    public void notifyStateChanged(ObjectState previousState, ObjectState state) {
//        if (getLabelWidget() != null) {
//            LookFeel lookFeel = getScene().getLookFeel();
//            getLabelWidget().setBorder(lookFeel.getBorder(state));
//            getLabelWidget().setForeground(lookFeel.getForeground(state));
//        }
    }

    /**
     * Sets an image.
     *
     * @param image the image
     */
    public final void setNodeImageWidget(NodeImageWidget nodeImageWidget) {
        this.nodeImageWidget = nodeImageWidget;
        addChild(nodeImageWidget);

        nodeImageWidget.setOpaque(false);
    }

    public final void removeNodeImageWidget() {
        nodeImageWidget.getParentWidget().removeChild(nodeImageWidget);
        this.nodeImageWidget = null;
    }

    /**
     * Sets a label.
     *
     * @param label the label
     */
//    public final LabelWidget addLabelWidget() {
//        setLabelWidget(new MultilineLabelWidget((Scene) scene));
//        getLabelWidget().setFont(((Scene) scene).getDefaultFont().deriveFont(12.0f));
//        addChild(getLabelWidget());
//        return getLabelWidget();
//    }
    /**
     * Returns the image widget part of the icon node widget.
     *
     * @return the image widget
     */
    public final NodeImageWidget getNodeImageWidget() {
        return nodeImageWidget;
    }



}
