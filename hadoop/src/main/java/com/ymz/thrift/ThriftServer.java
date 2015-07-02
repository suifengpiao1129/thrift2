package com.ymz.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

import com.ymz.thrift.HelloThrift.Processor;

public class ThriftServer {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void startServer(){
		try{
			TServerSocket serverTransport = new TServerSocket(55909);
			HelloThrift.Processor process=new Processor(new HelloThriftImpl());
			Factory portFactory= new TBinaryProtocol.Factory(true, true);
			 Args args = new Args(serverTransport);
	         args.processor(process);
	         args.protocolFactory(portFactory);
	         TServer server = new TThreadPoolServer(args);
	         System.out.println("port 55909 start!!!");
	         server.serve();
		}catch(TTransportException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ThriftServer tfs=new ThriftServer();
		tfs.startServer();
	}
}
