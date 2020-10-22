package org.vergen.views;

import org.eclipse.jface.viewers.*;
import org.eclipse.jface.action.*;
import org.eclipse.ui.*;
import org.eclipse.ui.part.*;
import org.vergen.views.commands.Invoker;
import org.vergen.views.factories.ActionsFactory;
import org.vergen.views.factories.WidgetsFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import javax.inject.Inject;

public class VerGenView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.vergen.views.VerGenView";

	@Inject
	IWorkbench workbench;

	private Action refreshAction = null;;
	private Widgets widgets = null;
	private Invoker invoker = null;

	public VerGenView() {
		widgets = new Widgets();
		invoker = new Invoker();
	}

	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		@Override
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}

		@Override
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}

		@Override
		public Image getImage(Object obj) {
			return workbench.getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(null);

		WidgetsFactory.createLabelVersionText(parent);
		WidgetsFactory.createLabelVersionValue(parent, widgets);

		WidgetsFactory.createSeparator(parent);

		WidgetsFactory.createLabelMajor(parent);
		WidgetsFactory.createSpinnerMajor(parent, widgets, invoker);

		WidgetsFactory.createLabelMinor(parent);
		WidgetsFactory.createSpinnerMinor(parent, widgets, invoker);

		WidgetsFactory.createLabelBugfix(parent);
		WidgetsFactory.createSpinnerBugfix(parent, widgets, invoker);

		WidgetsFactory.createLabelBuild(parent);
		WidgetsFactory.createSpinnerBuild(parent, widgets, invoker);

		WidgetsFactory.createButtonRefresh(parent, widgets, invoker);
		WidgetsFactory.createButtonGenerate(parent, widgets, invoker);
		
		WidgetsFactory.createLabelFileLocation(parent);
		WidgetsFactory.createHeaderFileLocation(parent);

		refreshAction = ActionsFactory.createRefreshAction(parent, widgets, invoker);
		contributeToActionBars();
		
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(refreshAction);	
	}


	@Override
	public void setFocus() {

	}
}
