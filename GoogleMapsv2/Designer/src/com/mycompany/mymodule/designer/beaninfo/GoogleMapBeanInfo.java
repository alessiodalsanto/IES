package com.mycompany.mymodule.designer.beaninfo;


import java.awt.Image;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.SimpleBeanInfo;
import javax.swing.*;

import javax.swing.ImageIcon;

import com.mycompany.mymodule.client.Map;
import com.inductiveautomation.factorypmi.designer.property.customizers.DynamicPropertyProviderCustomizer;
import com.inductiveautomation.factorypmi.designer.property.customizers.StyleCustomizer;
import com.inductiveautomation.vision.api.designer.beans.CommonBeanInfo;
import com.inductiveautomation.vision.api.designer.beans.CustomizerDescriptor;
import com.inductiveautomation.vision.api.designer.beans.VisionBeanDescriptor;

/**
 * This BeanInfo class describes the {@link HelloWorldComponent}, which is the component that this example module adds
 * to the Vision Module
 *
 * @author Carl
 */
public class GoogleMapBeanInfo extends CommonBeanInfo {

    public GoogleMapBeanInfo() {
		/*
		 * Our superclass constructor takes the class of the component we describe and the customizers that are
		 * applicable
		 */
        super(Map.class, new CustomizerDescriptor[] {
                DynamicPropertyProviderCustomizer.VALUE_DESCRIPTOR, StyleCustomizer.VALUE_DESCRIPTOR });
    }

    @Override
    protected void initProperties() throws IntrospectionException {
        // Adds common properties
        super.initProperties();

        // Remove some properties which aren't used in our component.
        removeProp("foreground");
        removeProp("background");
        removeProp("opaque");

        // Add our properties
        addProp("text", "Text", "The text to display in the component", CAT_DATA, PREFERRED_MASK | BOUND_MASK);

        addProp("animationRate", "Animation Rate", "The time between frames of animation, if it is turned on.",
                CAT_BEHAVIOR);

        addProp("fillColor", "Fill Color", "The color to fill the letters with.", CAT_APPEARANCE, PREFERRED_MASK);
        addProp("strokeColor", "Stroke Color", "The color to use for the letter outline.", CAT_APPEARANCE);
        addProp("strokeWidth", "Stroke Width", "The width of the letter outline, or 0 to turn outlining off.",
                CAT_APPEARANCE);
    }

    @Override
    public Image getIcon(int kind) {
        switch (kind) {
            case BeanInfo.ICON_COLOR_16x16:
            case BeanInfo.ICON_MONO_16x16:
            case SimpleBeanInfo.ICON_COLOR_32x32:
            case SimpleBeanInfo.ICON_MONO_32x32:
        }
        return null;
    }

    @Override
    protected void initDesc() {
        VisionBeanDescriptor bean = getBeanDescriptor();
        bean.setName("Google Maps");
        bean.setDisplayName("Google Maps");
        bean.setShortDescription("A component that displays the text 'Hello World'.");
    }

}