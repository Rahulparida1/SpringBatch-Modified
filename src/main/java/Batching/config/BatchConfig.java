package Batching.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import javax.sql.DataSource;

import Batching.entity.Customer;
import Batching.entity.Customerbackup;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	@Primary
	DataSource sourceDataSource() {
//		DriverManagerDataSource sdataSource = new DriverManagerDataSource();
		return DataSourceBuilder.create().url("jdbc:mysql://127.0.0.1:3306/springbatch").username("root")
				.password("root").driverClassName("com.mysql.cj.jdbc.Driver").build();
	}

	@Bean
	DataSource targetDataSource() {
//		DriverManagerDataSource tdataSource = new DriverManagerDataSource();
//		tdataSource.setUrl("jdbc:mysql://mysql-db.uat.bookone.io/new_testing");
//		tdataSource.setUsername("uat-apps-access");
//		tdataSource.setPassword("IVn7/R83@");
//		tdataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		return tdataSource;
		return DataSourceBuilder.create().url("jdbc:mysql://mysql-db.uat.bookone.io/new_testing")
				.username("uat-apps-access").password("IVn7/R83@").driverClassName("com.mysql.cj.jdbc.Driver").build();
	}

	// Reader to read data from the source database
//	@Bean
//	JdbcCursorItemReader<Customer> reader(@Qualifier("sourceDataSource") DataSource sourceDataSource) {
//		JdbcCursorItemReader<Customer> reader = new JdbcCursorItemReader<>();
//		reader.setDataSource(sourceDataSource);
//		reader.setSql("SELECT * FROM NEW_CUSTOMERS_INFO");
//		reader.setRowMapper(new BeanPropertyRowMapper<>(Customer.class));
//		return reader;
//	}
//
//	// Writer to write data to the target database
//	@Bean
//	JdbcBatchItemWriter<Customerbackup> writer(@Qualifier("targetDataSource") DataSource targetDataSource) {
//		JdbcBatchItemWriter<Customerbackup> writer = new JdbcBatchItemWriter<>();
//		writer.setDataSource(targetDataSource());
//		writer.setSql(
//				"INSERT INTO NEW_CUSTOMERS_INFO (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL, GENDER, CONTACT, COUNTRY, DOB) "
//						+ "VALUES (CUSTOMER_ID, FIRST_NAME, LAST_NAME, EMAIL, GENDER, CONTACT, COUNTRY, DOB)");
//		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
//		return writer;
//	}
//
//	// Define Step
//	@Bean
//	Step step1() {
//		return stepBuilderFactory.get("step1").<Customer, Customerbackup>chunk(100).reader(reader(sourceDataSource()))
//				.writer(writer(targetDataSource())).build();
//	}
//
//	// Define Job
//	@Bean
//	Job job() {
//		return jobBuilderFactory.get("migrateDataJob").start(step1()).build();
//	}
}
