package com.ymz.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftClient {
	public void startClient(String ip,String para){
		TTransport transport;		
		try {

			transport = new TSocket(ip, 55909);
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloThrift.Client client = new HelloThrift.Client(protocol);
            transport.open();
            String result;
			result = client.Hello2(para);
            System.out.println(result);
            transport.close();
		} catch (TTransportException e) {
			
			e.printStackTrace();
		}catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		ThriftClient tcl= new ThriftClient();
		tcl.startClient("localhost", "hello");
	}
}
