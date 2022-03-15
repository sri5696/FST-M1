import pytest
#addition
def test_addition():
    num1=10
    num2=20

    sum=num1+num2

    print(sum)

    assert sum==30

def test_sub():
    num3=20
    num4=10
    sub=num3-num4
    assert sub==10
def test_pro():
    num5=5
    num6=5
    pro=num5*num6
    assert pro==25
def test_quo():
    num6=30
    num7=3
    quo=num6/num7
    assert quo==10

