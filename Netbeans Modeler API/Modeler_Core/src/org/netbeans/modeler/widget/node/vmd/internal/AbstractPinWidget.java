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
package org.netbeans.modeler.widget.node.vmd.internal;

import java.awt.Image;
import java.util.List;
import org.netbeans.api.visual.anchor.Anchor;
import org.netbeans.api.visual.layout.LayoutFactory;
import org.netbeans.api.visual.model.ObjectState;
import org.netbeans.api.visual.vmd.VMDGlyphSetWidget;
import org.netbeans.api.visual.widget.ImageWidget;
import org.netbeans.api.visual.widget.LabelWidget;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;

public class AbstractPinWidget extends Widget {

    private PColorScheme scheme;
    private ImageWidget imageWidget;
    private LabelWidget nameWidget;
    private VMDGlyphSetWidget glyphsWidget;
    private PNodeAnchor anchor;

    /**
     * Creates a pin widget.
     *
     * @param scene the scene
     */
    public AbstractPinWidget(Scene scene) {
        this(scene, PFactory.getOriginalScheme());
    }

    /**
     * Creates a pin widget with a specific color scheme.
     *
     * @param scene the scene
     * @param scheme the color scheme
     */
    public AbstractPinWidget(Scene scene, PColorScheme scheme) {
        super(scene);
        assert scheme != null;
        this.scheme = scheme;

        setLayout(LayoutFactory.createHorizontalFlowLayout(LayoutFactory.SerialAlignment.CENTER, 8));

        addChild(imageWidget = new ImageWidget(scene));
        addChild(nameWidget = new LabelWidget(scene));
        addChild(glyphsWidget = new VMDGlyphSetWidget(scene));

        scheme.installUI(this);
        notifyStateChanged(ObjectState.createNormal(), ObjectState.createNormal());
    }

    /**
     * Sets a node image.
     *
     * @param image the image
     */
    public void setPinImage(Image image) {  // method added by gaurav gupta
        getImageWidget().setImage(image);
        revalidate();
    }

    /**
     * Called to notify about the change of the widget state.
     *
     * @param previousState the previous state
     * @param state the new state
     */
    protected void notifyStateChanged(ObjectState previousState, ObjectState state) {
        scheme.updateUI(this, previousState, state);
    }

    /**
     * Returns a pin name widget.
     *
     * @return the pin name widget
     */
    public Widget getPinNameWidget() {
        return nameWidget;
    }

    /**
     * Sets a pin name.
     *
     * @param name the pin name
     */
    public void setPinName(String name) {
        nameWidget.setLabel(name);
    }

    /**
     * Returns a pin name.
     *
     * @return the pin name
     */
    public String getPinName() {
        return nameWidget.getLabel();
    }

    /**
     * Sets pin glyphs.
     *
     * @param glyphs the list of images
     */
    public void setGlyphs(List<Image> glyphs) {
        glyphsWidget.setGlyphs(glyphs);
    }

    /**
     * Sets all pin properties at once.
     *
     * @param name the pin name
     * @param glyphs the pin glyphs
     */
    public void setProperties(String name, List<Image> glyphs) {
        setPinName(name);
        glyphsWidget.setGlyphs(glyphs);
    }

    /**
     * Creates a horizontally oriented anchor similar to
     * PNodeWidget.createAnchorPin
     *
     * @return the anchor
     */
    public Anchor createAnchor() {
        if (anchor == null) {
            anchor = new PNodeAnchor(this, false);
        }
        return anchor;
    }

    /**
     * @return the imageWidget
     */
    public ImageWidget getImageWidget() {
        return imageWidget;
    }
}