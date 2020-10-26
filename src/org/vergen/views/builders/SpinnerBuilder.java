package org.vergen.views.builders;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Spinner;
import org.vergen.views.Widgets;
import org.vergen.views.commands.Invoker;
import org.vergen.views.commands.Receiver;
import org.vergen.views.commands.UpdateViewCommand;

public class SpinnerBuilder {
	
	private Composite parent;
	private Widgets widgets;
	private Invoker invoker;
	private int x, y, width, height;
	
	public SpinnerBuilder(Composite parent) {
		this.parent = parent;
	}
	
	public SpinnerBuilder setBounds(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        return this;
    }
	
	public SpinnerBuilder setWidgets(Widgets widgets){
        this.widgets = widgets;
        return this;
    }
	
	public SpinnerBuilder setInvoker(Invoker invoker){
        this.invoker = invoker;
        return this;
    }
	
	public Spinner build() {
		Spinner spinner = new Spinner(parent, SWT.BORDER);
		spinner.setBounds(x, y, width, height);
		spinner.setMaximum(99);
	
		spinner.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				invoker.executeCommand(new UpdateViewCommand(new Receiver(widgets, parent)));
			}
		});

		return spinner;
		
	}

}
