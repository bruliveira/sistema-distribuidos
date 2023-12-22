from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler
from datetime import datetime

# Restrict to a particular path.
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
    
# Create server
with SimpleXMLRPCServer(('localhost', 21212),
                        requestHandler=RequestHandler) as server:
    server.register_introspection_functions()

    # Register a function
    functions = FunctionRPC()
    server.register_instance(functions)

    # Run the server's main loop
    server.serve_forever()