package com.github.kristofa.brave.resteasyexample;

import com.github.kristofa.brave.Brave;
import com.github.kristofa.brave.EmptySpanCollectorMetricsHandler;
import com.github.kristofa.brave.http.HttpRequest;
import com.github.kristofa.brave.http.HttpSpanCollector;
import com.github.kristofa.brave.http.ServiceNameProvider;
import com.github.kristofa.brave.http.SpanNameProvider;
import com.github.kristofa.brave.http.StringServiceNameProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BraveConfig {

	@Bean
	@Scope(value = "singleton")
	public Brave brave() {
		Brave.Builder builder = new Brave.Builder("OrderMock");
		// return builder.spanCollector(new
		// KafkaSpanCollector("192.168.99.100:9092"))
		// return builder.spanCollector(new
		// ScribeSpanCollector("192.168.99.100", 9410)).build();
		// return builder.spanCollector(new LoggingSpanCollector())
		// .traceFilters(Arrays.<TraceFilter>asList(new
		// FixedSampleRateTraceFilter(1)))
		// .build();
		return builder.spanCollector(
				HttpSpanCollector.create("http://192.168.99.100:9411/",
						new EmptySpanCollectorMetricsHandler())).build();
	}

	@Bean
	@Scope(value = "singleton")
	public ServiceNameProvider serviceNameProvider() {
		return new StringServiceNameProvider("Order");
	}

	@Bean
	@Scope(value = "singleton")
	public SpanNameProvider spanNameProvider() {
		return new SpanNameProvider(){

			@Override
			public String spanName(HttpRequest paramHttpRequest) {
				return paramHttpRequest.getUri().getPath();
			}
			
		};
	}
}
