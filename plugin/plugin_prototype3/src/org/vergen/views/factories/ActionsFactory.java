package org.vergen.views.factories;

import org.eclipse.swt.widgets.Composite;
import org.vergen.views.Messages;
import org.vergen.views.Widgets;
import org.vergen.views.commands.Invoker;
import org.vergen.views.commands.Receiver;
import org.vergen.views.commands.RefreshCommand;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;

public final class ActionsFactory {

	public static Action createRefreshAction(Composite parent, Widgets widgets, Invoker invoker) {
		ImageDescriptor imageDesc = createImageDescriptor(Messages.RefreshActionImageUrl);
		Action action = new Action() {
			public void run() {
				invoker.executeCommand(new RefreshCommand(new Receiver(widgets, parent)));
			}
		};
		action.setText(Messages.refreshActionText);
		action.setToolTipText(Messages.refreshActionToolTip);
		action.setImageDescriptor(imageDesc);

		return action;
	}

	private static ImageDescriptor createImageDescriptor(String url) {
		URL urlTmp = null;

		try {
			urlTmp = new URL(url);
		} catch (MalformedURLException e) {
		}

		ImageDescriptor imageDesc = ImageDescriptor.createFromURL(urlTmp);
		return imageDesc;
	}

}