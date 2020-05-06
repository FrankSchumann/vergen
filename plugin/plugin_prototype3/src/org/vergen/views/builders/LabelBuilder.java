package org.vergen.views.builders;

import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class LabelBuilder {
	
	private Composite parent;
	private String text;
	int x, y, width, height;
	int style = SWT.NORMAL;
	
	public LabelBuilder(Composite parent) {
		this.parent = parent;
	}
	
	public LabelBuilder setText(String text) {
		this.text = text;
		return this;
	}
	
	public LabelBuilder setBounds(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        return this;
    }
	
	public LabelBuilder setStyle(int style) {
		this.style = style;
		return this;
	}
	
	public Label build() {
		Label label = new Label(parent, SWT.NONE);
		label.setBounds(x,y, width, height);
		label.setText(text);
		
		FontDescriptor boldDescriptor = FontDescriptor.createFrom(label.getFont()).setStyle(this.style);
		Font font = boldDescriptor.createFont(label.getDisplay());
		label.setFont(font);
		
		return label;
	}

}
