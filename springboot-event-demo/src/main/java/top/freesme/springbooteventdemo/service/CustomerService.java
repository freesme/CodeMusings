package top.freesme.springbooteventdemo.service;

import jakarta.annotation.Resource;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import top.freesme.springbooteventdemo.event.AdsenseReportEvent;

@Service
public class CustomerService {

	@Resource
	private ApplicationEventPublisher applicationEventPublisher;

	public void publishEvent(String msg) {
		AdsenseReportEvent event = new AdsenseReportEvent(this, msg);
		System.out.println(Thread.currentThread().getName() + " publishEvent === " + msg);
		applicationEventPublisher.publishEvent(event);
	}

}
