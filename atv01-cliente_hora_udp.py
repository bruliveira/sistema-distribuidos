import socket

# Criando um socket UDP
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

server_address = ('localhost', 20001)
print("Conectando %s porta %s" % server_address)

while True:
    message = input("Digite a mensagem a ser enviada, please: ")
    sock.sendto(message.encode('utf-8'), server_address)
    if message == '0':
        break
    data, _ = sock.recvfrom(2048)
    mensagem = data.decode()
    if mensagem != '0':
        print(data.decode())

sock.close()