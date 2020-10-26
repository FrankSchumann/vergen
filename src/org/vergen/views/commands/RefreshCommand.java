package org.vergen.views.commands;

public class RefreshCommand implements Command {
	
	Receiver receiver;
	
	public RefreshCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.refresh();
	};
}
