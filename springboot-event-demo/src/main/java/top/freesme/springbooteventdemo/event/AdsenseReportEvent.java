package top.freesme.springbooteventdemo.event;

import org.springframework.context.ApplicationEvent;

public class AdsenseReportEvent extends ApplicationEvent {

	private final String msg;

	public AdsenseReportEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}

}
