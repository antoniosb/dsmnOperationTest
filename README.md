dsmnOperationTest
=================

Simple project to write Junit tests for each current DSMN operation, and validate its WSDL responses. 

Currently, the tests are running Ok on the local environment. Except for these listed bellow:

modifyElegido
modifyMultiplesElegido
RegisterMultiplesElegidoWithValidity

The 'modify' ones error is related to the GetFaF command not being properly mocked. 
The 'register' one is a strange nullPointerException. 


