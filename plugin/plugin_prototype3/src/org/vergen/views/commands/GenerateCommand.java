package org.vergen.views.commands;

public class GenerateCommand implements Command {
	
	Receiver receiver;
	
	public GenerateCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	
	@Override
	public void execute() {
		receiver.generate();
	};
}
