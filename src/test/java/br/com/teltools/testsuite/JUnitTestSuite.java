package br.com.teltools.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.teltools.dsmn.ActivateSubscriberTest;
import br.com.teltools.dsmn.CancelSubscriptionTest;
import br.com.teltools.dsmn.ChangeMsisdnTest;
import br.com.teltools.dsmn.ChangeSubscriberDetailsTest;
import br.com.teltools.dsmn.CreateNewSubscriptionTest;
import br.com.teltools.dsmn.DeleteElegidosTest;
import br.com.teltools.dsmn.EnquireElegidosTest;
import br.com.teltools.dsmn.GeneralCancellationTest;
import br.com.teltools.dsmn.GetAllCommercialProductsTest;
import br.com.teltools.dsmn.GetSubscriptionsTest;
import br.com.teltools.dsmn.ModifyElegidoTest;
import br.com.teltools.dsmn.ModifyMultiplesElegidoTest;
import br.com.teltools.dsmn.ReSubscriptionTest;
import br.com.teltools.dsmn.ReactivateSubscriptionTest;
import br.com.teltools.dsmn.RegisterElegidoTest;
import br.com.teltools.dsmn.RegisterMultiplesElegidoTest;
import br.com.teltools.dsmn.RenewalElegidosTest;
import br.com.teltools.dsmn.SuspendSubscriptionTest;
import br.com.teltools.dsmn.UnregisterElegidoTest;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	ActivateSubscriberTest.class,
	CancelSubscriptionTest.class,
	ChangeMsisdnTest.class,
	ChangeSubscriberDetailsTest.class,
	CreateNewSubscriptionTest.class,
	DeleteElegidosTest.class,
	EnquireElegidosTest.class,
	GeneralCancellationTest.class,
	GetAllCommercialProductsTest.class,
	GetSubscriptionsTest.class,
	ModifyElegidoTest.class,
	ModifyMultiplesElegidoTest.class,
	ReactivateSubscriptionTest.class,
	RegisterElegidoTest.class,
	RegisterMultiplesElegidoTest.class,
	RenewalElegidosTest.class,
	ReSubscriptionTest.class,
	SuspendSubscriptionTest.class,
	UnregisterElegidoTest.class
})
public class JUnitTestSuite {
}
