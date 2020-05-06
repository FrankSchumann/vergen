package org.vergen.views.commands;

public class UpdateViewCommand implements Command {
	
	Receiver receiver;
	
	public UpdateViewCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.updateView();
	};
}
