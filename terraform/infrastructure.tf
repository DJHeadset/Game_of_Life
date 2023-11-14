terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 4.0"
    }
  }
}

provider "aws" {
  region = "eu-north-1"
}

resource "aws_instance" "public_instance" {
  ami                    = "ami-0fe8bec493a81c7da"
  instance_type          = "t3.micro"
  key_name               = "brandnew"
  subnet_id              = "subnet-00a203a95fd189f98"
  associate_public_ip_address = true

  tags = {
    Name = "public_instance"
  }
}
