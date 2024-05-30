package stepDefinitions;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.compress.archivers.zip.PKWareExtraHeader.HashAlgorithm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;

public class Data {
	@Given("Michael is a Morning Freshness member")
	public void michael_is_a_morning_freshness_member() {
		System.out.println("Start");
	}

	@When("he orders an {string} and a cappuccino and {int} croissants")
	public void he_orders_an_and_a_cappuccino_and_croissants(String string, Integer int1) {
		System.out.println(string + " = " + int1);

	}

	@Then("his order should go to the preparation queue")
	public void his_order_should_go_to_the_preparation_queue() {
		System.out.println("End");

	}

	@When("he places the following order:")
	public void he_places_the_following_order(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
//		HashMap<String, Integer> map = new HashMap<String, Integer>(dataTable);
	}
}
