package com.mycompany.mymodule.designer;

import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;
import com.inductiveautomation.vision.api.designer.VisionDesignerInterface;
import com.inductiveautomation.vision.api.designer.palette.JavaBeanPaletteItem;
import com.inductiveautomation.vision.api.designer.palette.Palette;
import com.inductiveautomation.vision.api.designer.palette.PaletteItemGroup;
import com.mycompany.mymodule.client.Map;
import javax.swing.*;

public class DesignerHook extends AbstractDesignerModuleHook {

	public static final String MODULE_ID = "Google-Maps";

	@Override
	public void startup(DesignerContext context, LicenseState activationState) throws Exception {
		// Add the BeanInfo package to the search path
		context.addBeanInfoSearchPath("com.mycompany.mymodule.designer.beaninfo");

		// Add my component to its own palette
		VisionDesignerInterface sdk = (VisionDesignerInterface) context
				.getModule(VisionDesignerInterface.VISION_MODULE_ID);
		if (sdk != null) {
			Palette palette = sdk.getPalette();

			PaletteItemGroup group = palette.addGroup("Maps");
			group.addPaletteItem(new JavaBeanPaletteItem(Map.class));
		}

        super.startup(context, activationState);
	}
	
}
