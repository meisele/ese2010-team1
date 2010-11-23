<span class="like">

	
	${_entry.getLikeCount()} People like this. 
	#{if _user && _user != _entry.owner()}
	<a href="
	

		
		#{if _entry instanceof models.Answer}
			@{Secured.likeAnswer(_entry.question().id, _entry.id)}
		#{/if}
		
		#{else}
			@{Secured.likeQuestion(_entry.id)}

		#{/else}
	
	">Like it</a>
	#{/if}
	



</span>




		
		
	