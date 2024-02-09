#Importar biblioteca
import xmlrpc.client
import socket
#Definir servidor
s = xmlrpc.client.ServerProxy('http://localhost:21212')

#Chamar funções disponíveis no servidor
print(s.add(2,3))  # Returns 5
s.armazenar(socket.gethostname())
s.armazenar("Mensagem 2")
print(s.getMensagens())

# Print list of available methods
print(s.system.listMethods())