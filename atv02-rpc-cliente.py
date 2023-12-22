import xmlrpc.client

servidorLocal = xmlrpc.client.ServerProxy('http://localhost:21212')
servidorRemoto = xmlrpc.client.ServerProxy('http://localhost:21213')

print(f'\n--> Servidor local')
print(servidorLocal)
print(f'Data e hora atual: {servidorLocal.data_hora_atual()}')
print(f'Quantidade de chamadas recebidas: {servidorLocal.qtd_chamadas_recebidas()}')

print(f'\n--> Servidor remoto')
print(servidorRemoto)
print(f'Data e hora atual: {servidorRemoto.data_hora_atual()}')
print(f'Quantidade de chamadas recebidas: {servidorRemoto.qtd_chamadas_recebidas()}')