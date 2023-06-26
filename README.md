#  Implementierte Sicherheitsmechanismen und deren Verbesserungen:
## 1. Verwendung korrekter REST-Verben:
   Ich habe bei der Implementierung meiner RESTful-APIs die korrekten HTTP-Verben verwendet. Dies trägt dazu bei, den Zweck und die Funktionen der verschiedenen Endpunkte meiner APIs klar zu definieren und das Verständnis für andere Entwickler zu verbessern. (In Controllers)

## 2. Implementierung einer Authentifizierungslösung (BasicAuth):
   Ich habe ein benutzerdefiniertes Authentifizierungssystem implementiert, das auf Spring Security und BasicAuth basiert. Dies stellt sicher, dass nur authentifizierte Benutzer Zugang zu bestimmten Bereichen meiner Anwendung haben und verbessert die allgemeine Sicherheit.

## 3. Enforce RBAC (User- und Admin-Services unterscheiden):
   Durch die Implementierung von Role Based Access Control (RBAC) konnte ich Berechtigungen für verschiedene Benutzerrollen festlegen. Dies stellt sicher, dass Benutzer nur Zugriff auf die Ressourcen haben, für die sie die entsprechenden Berechtigungen haben. (In Services)

## 4. Aktivierung von CSRF-Protection:
   Ich habe CSRF-Schutz durch Verwendung des in Spring Security integrierten CSRF-Schutzes aktiviert. Diese Maßnahme schützt meine Anwendung vor Cross-Site Request Forgery (CSRF) Angriffen, bei denen ein böswilliger Benutzer die Identität eines anderen Benutzers missbraucht. (SecurityConfiguration)

## 5. Implementierung einer sicheren Passwort-Speicherung (Hashing, Passwortregeln):
   Passwörter werden unter Verwendung von BCrypt gehasht und in der Datenbank gespeichert. Dies verhindert, dass im Falle einer Datenbankkompromittierung Passwörter im Klartext sichtbar sind. (SecurityConfiguration)

## 6. Strikte Inputvalidierung (für REST-Endpunkte und Datenbank):
   Durch die Implementierung einer strengen Inputvalidierung konnte ich sicherstellen, dass nur gültige Daten in mein System eingegeben werden. Dies schützt meine Anwendung vor verschiedenen Arten von Angriffen, einschließlich SQL-Injection und Cross-Site Scripting (XSS). (In Entities)

## 7. Behebung der initialen Sicherheitslücken (SQLi, XSS, CSRF):
   Alle initialen Sicherheitslücken wurden identifiziert und behoben. Hierzu gehört auch die Implementierung von Schutzmaßnahmen gegen SQL-Injection, Cross-Site Scripting (XSS) und Cross-Site Request Forgery (CSRF) Angriffe. (SecurityConfiguration)

## 8. Implementierung von securityrelevanten (Unit-)Tests:
   Ich habe Unit-Tests durchgeführt, um sicherzustellen, dass alle implementierten Sicherheitsmechanismen wie erwartet funktionieren. Dies hilft, potenzielle Sicherheitslücken zu identifizieren und zu beheben, bevor sie ausgenutzt werden können. (In Tests)

# Zusätzliche Sicherheitsverbesserungen:
## 1. Setzen von sicherheitsrelevanten HTTP-Headers (Content-Security-Policy):
   Ich habe den Content-Security-Policy (CSP) HTTP Header gesetzt, um zu verhindern, dass bösartige Inhalte auf meiner Website geladen werden. Dies bietet zusätzlichen Schutz gegen bestimmte Arten von Angriffen, wie Cross-Site Scripting (XSS). (SecurityConfiguration)

## 2. Limit auf fehlerhaften Loginversuchen:
   Ich habe ein System implementiert, das die Anzahl der fehlgeschlagenen Loginversuche eines Benutzers begrenzt. Dies hilft, Brute-Force-Angriffe zu verhindern. (In Provider)

## 3. Weniger Information-Disclosure via Fehlermeldungen:
   Durch den Einsatz eines globalen Exception-Handlers konnte ich sicherstellen, dass meine Anwendung keine sensiblen Informationen durch Fehlermeldungen preisgibt. Dies schützt meine Anwendung, indem es Angreifern erschwert wird, durch Auswertung von Fehlermeldungen an nützliche Informationen zu gelangen. (GlobalExceptionHandler)

# Etwas komplexere Erweitereungen
# Aktivierung von HTTPS mit einem Self-Signed Zertifikat
Um die Kommunikation zwischen Client und Server zu verschlüsseln und die Sicherheit unserer Anwendung zu erhöhen, habe ich HTTPS aktiviert. Hierfür habe ich ein Self-Signed Zertifikat erstellt und verwendet.

Die nötigen Einstellungen habe ich in der application.properties-Datei vorgenommen

Aktivierung von HTTPS mit einem Self-Signed Zertifikat
Um die Kommunikation zwischen Client und Server zu verschlüsseln und die Sicherheit unserer Anwendung zu erhöhen, habe ich HTTPS aktiviert. Hierfür habe ich ein Self-Signed Zertifikat erstellt und verwendet.

Die nötigen Einstellungen habe ich in der application.properties-Datei vorgenommen
   
# Weitere Implementationen die möglich wären
# 1. Implementierung einer Zwei-Faktor-Authentifizierung (2FA):
   Zwei-Faktor-Authentifizierung bietet eine zusätzliche Sicherheitsebene für die Benutzerkonten. Selbst wenn jemand das Passwort eines Benutzers errät oder stiehlt, würde er ohne den zweiten Faktor (z.B. eine Einmal-Passwort per SMS oder eine Anwendung für die 2FA) keinen Zugang zum Konto erhalten.

# Reflektion

Zu Beginn meines Projekts stand ich vor der Herausforderung, einen geeigneten Startpunkt zu finden, was mich zunächst vor Schwierigkeiten stellte. Insbesondere die Implementierung von CSRF-Schutz stellte sich als komplex heraus. Da es zunächst nicht wie geplant funktionierte, war ich gezwungen, verschiedene Ansätze auszuprobieren und gründliche Tests durchzuführen, um die Funktionalität sicherzustellen.

Eine weitere bedeutende Herausforderung war die Entwicklung der Klasse CustomAuthenticationProvider. Es war schwierig für mich, die Sicherheitsprotokolle für den Login-Prozess korrekt zu programmieren. Das größte Problem war, dass ich auf ein Hindernis stieß, bei dem der Login-Prozess nicht funktionierte.
Betrachte ich mein Projekt rückblickend, sehe ich deutlich Verbesserungspotential in der Verwaltung der Benutzerrollen. Die aktuelle Implementierung könnte flexibler sein, um eine effektivere Handhabung verschiedener Rollen und Berechtigungen zu ermöglichen.

Obwohl mein Projekt aufgrund seiner Komplexität schwierig war, hat es mir wertvolle Lektionen für zukünftige Arbeiten geliefert. Jede einzelne Herausforderung hat dazu beigetragen, mein Verständnis und meine Fähigkeiten zu erweitern, und ich freue mich darauf, diese Erfahrungen in zukünftige Projekte einzubringen.
