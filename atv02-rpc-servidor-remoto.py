from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler
from datetime import datetime

class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2',)

class FunctionRPC:    
    def __init__(self):
        self.call_count = 0

    def data_hora_atual(self):
        return datetime.now().strftime("%Y-%m-%d %H:%M:%S")

    def qtd_chamadas_recebidas(self):
        self.call_count += 1
        return self.call_count
    

with SimpleXMLRPCServer(('localhost', 21213), #Adicona o ip a ser acessado
                        requestHandler=RequestHandler) as server:

    server.register_introspection_functions()

    functions = FunctionRPC()
    server.register_instance(functions)

    server.serve_forever()
