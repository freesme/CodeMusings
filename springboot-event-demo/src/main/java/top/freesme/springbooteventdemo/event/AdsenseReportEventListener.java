package top.freesme.springbooteventdemo.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AdsenseReportEventListener {

	@Async
	@EventListener
	public void receiveMsg(AdsenseReportEvent event) {
		System.out.println("receiveMSG === " + event.getMsg());
		System.out.println(Thread.currentThread().getName());
	}

}
