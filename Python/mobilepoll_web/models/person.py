#!/usr/bin/env python
# -*- coding: utf-8 -*-

from django.db import models
from django.utils import timezone
import uuid


class Person(models.Model):
	def __str__(self):
		return self.name

	PERSON_TYPE = (
		(2, 'Pessoa Física'),
		(1, 'Pessoa Jurídica')
	)

	GENDER_TYPE = (
		(2, 'Male'),
		(1, 'Female')
	)

	MARITAL_STATUS = (
		(0, 'Outro'),
		(1, 'Solteiro'),
		(2, 'Casado'),
		(3, 'Viúvo'),
		(4, 'Divorciado'),
		(5, 'União Estável')
	)

	name = models.CharField(db_column='Nome', max_length=200, null=False)
	shortName = models.CharField(db_column='NomeAbreviado', max_length=120, null=True, blank=True)
	primaryEmail = models.CharField(db_column='EmailPrincipal', max_length=120, null=True, blank=True)
	secondaryEmail = models.CharField(db_column='EmailSecundario', max_length=120, null=True, blank=True)
	cpf = models.CharField(db_column='CPF', max_length=14, null=True, blank=True)
	cnpj = models.CharField(db_column='CNPJ', max_length=32, null=True, blank=True)
	corporateName = models.CharField(db_column='RazaoSocial', max_length=200, null=True, blank=True)
	stateInscription = models.CharField(db_column='InscricaoEstadual', max_length=50, null=True, blank=True)
	municipalInscription = models.CharField(db_column='InscricaoMunicipal', max_length=50, null=True, blank=True)
	gender = models.IntegerField(db_column='Sexo', choices=GENDER_TYPE, null=True, blank=True)
	maritalStatus = models.IntegerField(db_column='EstadoCivil', max_length=1, choices=MARITAL_STATUS, null=True, blank=True)
	birthday = models.DateField(db_column='DataDeNascimento', null=True, editable=True, blank=True)
	personKey = models.UUIDField(db_column='ChavePessoa', default=uuid.uuid4, editable=False, null=False)
	isValid = models.BooleanField(db_column='Valido', default=True, null=False, blank=True)
	activationKey = models.UUIDField(db_column='ChaveAtivacao', default=uuid.uuid4, editable=False, null=True, blank=True)
	activationDate = models.DateTimeField(db_column='DataAtivacao', default=timezone.now, blank=True)
	registerDateTime = models.DateTimeField(db_column='DataHoraRegistro', null=False, default=timezone.now, editable=False)
	lastUpdateDateTime = models.DateTimeField(db_column='DataHoraUltimaAtualizacao', null=False, default=timezone.now, editable=False)
	deleteDateTime = models.DateTimeField(db_column='DataHoraExclusao', null=True, editable=False)
	deleteKey = models.CharField(db_column='ChaveExclusao', max_length=64, null=True, editable=False)
	registerNumber = models.CharField(db_column='NumeroDeRegistro', max_length=64, null=True, blank=True)
	comments = models.TextField(db_column='comentarios', null=True, blank=True)