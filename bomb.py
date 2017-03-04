from random import randrange
from subprocess import Popen
for i in range(2):
    name = "a%010d.py"%randrange(0,100000000000)
    l = open('bomb.py','r').read().split('\n')
    l[4] = l[4][:10]+name[:-3]+l[4][l[4].index('.py'):]
    open(name,'w').write('\n'.join(l))
    Popen(['python',name])
