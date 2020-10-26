package org.vergen.views.builders;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.vergen.views.Widgets;
import org.vergen.views.commands.Command;
import org.vergen.views.commands.Invoker;

public class ButtonBuilder {
	
	private Widgets widgets;
	private Composite parent;
	private Invoker invoker;
	private Command command;
	private String text;
	private int x, y, width, height;
	
	public ButtonBuilder(Composite parent) {
		this.parent = parent;
	}
	
	public ButtonBuilder setWidgets(Widgets widgets){
		this.widgets = widgets;
		return this;
	}
	
	public ButtonBuilder setInvoker(Invoker invoker){
		this.invoker = invoker;
		return this;
	}
	
	public ButtonBuilder setCommand(Command command) {
		this.command = command;
		return this;
	}
	
	public ButtonBuilder setText(String text){
		this.text = text;
		return this;
	}
	
	public ButtonBuilder setBounds(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        return this;
    }
	
	
	public Button build() {
		Button button = new Button(parent, SWT.FLAT);
		button.setBounds(x, y, width, height);
		button.setText(text);

		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				invoker.executeCommand(command);
			}
		});

		return button;		
	}

}
