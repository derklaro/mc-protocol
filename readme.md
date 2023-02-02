# 23w05a (Snapshot)
| Series | Java Runtime | Java Version | Protocol Version | World Version | Pack Resource Version | Pack Data Version | Built at (UTC) |
| -------------| -------------| -------------| -------------| -------------| -------------| -------------| -------------|
| main| java-runtime-gamma| 17| 1073741941| 3323| 12| 11| 01/02/2023 14:15:46|
## Handshaking (Serverbound)
#### 0x00 - Client Intention Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| protocolVersion| int| int|
| 1| 0| hostName| String| String|
| 2| 1| port| int| int|
| 3| 0| intention| ConnectionProtocol| ConnectionProtocol|
 
## Handshaking (Clientbound)
This packet flow has no registered packets
## Play (Serverbound)
#### 0x00 - Accept Teleportation Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x01 - Block Entity Tag Query (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| pos| BlockPos| BlockPos|
 
#### 0x02 - Change Difficulty Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| difficulty| Difficulty| Difficulty|
 
#### 0x03 - Chat Ack Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| offset| int| int|
 
#### 0x04 - Chat Command Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| command| String| String|
| 1| 0| timeStamp| Instant| Instant|
| 2| 0| salt| long| long|
| 3| 0| argumentSignatures| ArgumentSignatures| ArgumentSignatures|
| 4| 0| lastSeenMessages| LastSeenMessages$Update| LastSeenMessages$Update|
 
#### 0x05 - Chat Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| message| String| String|
| 1| 0| timeStamp| Instant| Instant|
| 2| 0| salt| long| long|
| 3| 0| signature| MessageSignature| MessageSignature|
| 4| 0| lastSeenMessages| LastSeenMessages$Update| LastSeenMessages$Update|
 
#### 0x06 - Chat Session Update Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| chatSession| RemoteChatSession$Data| RemoteChatSession$Data|
 
#### 0x07 - Client Command Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ServerboundClientCommandPacket$Action| ServerboundClientCommandPacket$Action|
 
#### 0x08 - Client Information Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| language| String| String|
| 1| 0| viewDistance| int| int|
| 2| 0| chatVisibility| ChatVisiblity| ChatVisiblity|
| 3| 0| chatColors| boolean| boolean|
| 4| 1| modelCustomisation| int| int|
| 5| 0| mainHand| HumanoidArm| HumanoidArm|
| 6| 1| textFilteringEnabled| boolean| boolean|
| 7| 2| allowsListing| boolean| boolean|
 
#### 0x09 - Command Suggestion Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| command| String| String|
 
#### 0x0A - Container Button Click Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| buttonId| int| int|
 
#### 0x0B - Container Click Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| stateId| int| int|
| 2| 2| slotNum| int| int|
| 3| 3| buttonNum| int| int|
| 4| 0| clickType| ClickType| ClickType|
| 5| 0| carriedItem| ItemStack| ItemStack|
| 6| 0| changedSlots| Int2ObjectMap| Int2ObjectMap&lt;ItemStack&gt;|
 
#### 0x0C - Container Close Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
 
#### 0x0D - Custom Payload Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| identifier| ResourceLocation| ResourceLocation|
| 1| 0| data| FriendlyByteBuf| FriendlyByteBuf|
 
#### 0x0E - Edit Book Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
| 1| 0| pages| List| List&lt;String&gt;|
| 2| 0| title| Optional| Optional&lt;String&gt;|
 
#### 0x0F - Entity Tag Query (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 1| entityId| int| int|
 
#### 0x10 - Interact Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| action| ServerboundInteractPacket$Action| ServerboundInteractPacket$Action|
| 2| 0| usingSecondaryAction| boolean| boolean|
 
#### 0x11 - Jigsaw Generate Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| levels| int| int|
| 2| 0| keepJigsaws| boolean| boolean|
 
#### 0x12 - Keep Alive Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| long| long|
 
#### 0x13 - Lock Difficulty Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| locked| boolean| boolean|
 
#### 0x14 - Pos (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| onGround| boolean| boolean|
| 6| 1| hasPos| boolean| boolean|
| 7| 2| hasRot| boolean| boolean|
 
#### 0x15 - Pos Rot (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| onGround| boolean| boolean|
| 6| 1| hasPos| boolean| boolean|
| 7| 2| hasRot| boolean| boolean|
 
#### 0x16 - Rot (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| onGround| boolean| boolean|
| 6| 1| hasPos| boolean| boolean|
| 7| 2| hasRot| boolean| boolean|
 
#### 0x17 - Status Only (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| onGround| boolean| boolean|
| 6| 1| hasPos| boolean| boolean|
| 7| 2| hasRot| boolean| boolean|
 
#### 0x18 - Move Vehicle Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
 
#### 0x19 - Paddle Boat Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| left| boolean| boolean|
| 1| 1| right| boolean| boolean|
 
#### 0x1A - Pick Item Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
 
#### 0x1B - Place Recipe Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| recipe| ResourceLocation| ResourceLocation|
| 2| 0| shiftDown| boolean| boolean|
 
#### 0x1C - Player Abilities Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| isFlying| boolean| boolean|
 
#### 0x1D - Player Action Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| direction| Direction| Direction|
| 2| 0| action| ServerboundPlayerActionPacket$Action| ServerboundPlayerActionPacket$Action|
| 3| 0| sequence| int| int|
 
#### 0x1E - Player Command Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| action| ServerboundPlayerCommandPacket$Action| ServerboundPlayerCommandPacket$Action|
| 2| 1| data| int| int|
 
#### 0x1F - Player Input Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| xxa| float| float|
| 1| 1| zza| float| float|
| 2| 0| isJumping| boolean| boolean|
| 3| 1| isShiftKeyDown| boolean| boolean|
 
#### 0x20 - Pong Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x21 - Recipe Book Change Settings Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| bookType| RecipeBookType| RecipeBookType|
| 1| 0| isOpen| boolean| boolean|
| 2| 1| isFiltering| boolean| boolean|
 
#### 0x22 - Recipe Book Seen Recipe Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| recipe| ResourceLocation| ResourceLocation|
 
#### 0x23 - Rename Item Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| name| String| String|
 
#### 0x24 - Resource Pack Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ServerboundResourcePackPacket$Action| ServerboundResourcePackPacket$Action|
 
#### 0x25 - Seen Advancements Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ServerboundSeenAdvancementsPacket$Action| ServerboundSeenAdvancementsPacket$Action|
| 1| 0| tab| ResourceLocation| ResourceLocation|
 
#### 0x26 - Select Trade Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| item| int| int|
 
#### 0x27 - Set Beacon Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| primary| Optional| Optional&lt;MobEffect&gt;|
| 1| 1| secondary| Optional| Optional&lt;MobEffect&gt;|
 
#### 0x28 - Set Carried Item Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
 
#### 0x29 - Set Command Block Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| command| String| String|
| 2| 0| trackOutput| boolean| boolean|
| 3| 1| conditional| boolean| boolean|
| 4| 2| automatic| boolean| boolean|
| 5| 0| mode| CommandBlockEntity$Mode| CommandBlockEntity$Mode|
 
#### 0x2A - Set Command Minecart Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entity| int| int|
| 1| 0| command| String| String|
| 2| 0| trackOutput| boolean| boolean|
 
#### 0x2B - Set Creative Mode Slot Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slotNum| int| int|
| 1| 0| itemStack| ItemStack| ItemStack|
 
#### 0x2C - Set Jigsaw Block Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| name| ResourceLocation| ResourceLocation|
| 2| 1| target| ResourceLocation| ResourceLocation|
| 3| 2| pool| ResourceLocation| ResourceLocation|
| 4| 0| finalState| String| String|
| 5| 0| joint| JigsawBlockEntity$JointType| JigsawBlockEntity$JointType|
 
#### 0x2D - Set Structure Block Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| updateType| StructureBlockEntity$UpdateType| StructureBlockEntity$UpdateType|
| 2| 0| mode| StructureMode| StructureMode|
| 3| 0| name| String| String|
| 4| 1| offset| BlockPos| BlockPos|
| 5| 0| size| Vec3i| Vec3i|
| 6| 0| mirror| Mirror| Mirror|
| 7| 0| rotation| Rotation| Rotation|
| 8| 1| data| String| String|
| 9| 0| ignoreEntities| boolean| boolean|
| 10| 1| showAir| boolean| boolean|
| 11| 2| showBoundingBox| boolean| boolean|
| 12| 0| integrity| float| float|
| 13| 0| seed| long| long|
 
#### 0x2E - Sign Update Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| lines| String[]| String[]|
 
#### 0x2F - Swing Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| hand| InteractionHand| InteractionHand|
 
#### 0x30 - Teleport To Entity Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| uuid| UUID| UUID|
 
#### 0x31 - Use Item On Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| blockHit| BlockHitResult| BlockHitResult|
| 1| 0| hand| InteractionHand| InteractionHand|
| 2| 0| sequence| int| int|
 
#### 0x32 - Use Item Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| hand| InteractionHand| InteractionHand|
| 1| 0| sequence| int| int|
 
## Play (Clientbound)
#### 0x00 - Bundle Delimiter Packet (S ➔ C)
Packet has no fields
 
#### 0x01 - Add Entity Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| uuid| UUID| UUID|
| 2| 0| type| EntityType| EntityType&lt;?&gt;|
| 3| 0| x| double| double|
| 4| 1| y| double| double|
| 5| 2| z| double| double|
| 6| 1| xa| int| int|
| 7| 2| ya| int| int|
| 8| 3| za| int| int|
| 9| 0| xRot| byte| byte|
| 10| 1| yRot| byte| byte|
| 11| 2| yHeadRot| byte| byte|
| 12| 4| data| int| int|
 
#### 0x02 - Add Experience Orb Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| x| double| double|
| 2| 1| y| double| double|
| 3| 2| z| double| double|
| 4| 1| value| int| int|
 
#### 0x03 - Add Player Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| playerId| UUID| UUID|
| 2| 0| x| double| double|
| 3| 1| y| double| double|
| 4| 2| z| double| double|
| 5| 0| yRot| byte| byte|
| 6| 1| xRot| byte| byte|
 
#### 0x04 - Animate Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 1| action| int| int|
 
#### 0x05 - Award Stats Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| stats| Object2IntMap| Object2IntMap&lt;Stat&lt;?&gt;&gt;|
 
#### 0x06 - Block Changed Ack Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sequence| int| int|
 
#### 0x07 - Block Destruction Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| pos| BlockPos| BlockPos|
| 2| 1| progress| int| int|
 
#### 0x08 - Block Entity Data Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| type| BlockEntityType| BlockEntityType&lt;?&gt;|
| 2| 0| tag| CompoundTag| CompoundTag|
 
#### 0x09 - Block Event Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| b0| int| int|
| 2| 1| b1| int| int|
| 3| 0| block| Block| Block|
 
#### 0x0A - Block Update Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| blockState| BlockState| BlockState|
 
#### 0x0B - Boss Event Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| UUID| UUID|
| 1| 0| operation| ClientboundBossEventPacket$Operation| ClientboundBossEventPacket$Operation|
 
#### 0x0C - Change Difficulty Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| difficulty| Difficulty| Difficulty|
| 1| 0| locked| boolean| boolean|
 
#### 0x0D - Clear Titles Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| resetTimes| boolean| boolean|
 
#### 0x0E - Command Suggestions Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| suggestions| Suggestions| Suggestions|
 
#### 0x0F - Commands Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| rootIndex| int| int|
| 1| 0| entries| List| List&lt;ClientboundCommandsPacket$Entry&gt;|
 
#### 0x10 - Container Close Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
 
#### 0x11 - Container Set Content Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| stateId| int| int|
| 2| 0| items| List| List&lt;ItemStack&gt;|
| 3| 0| carriedItem| ItemStack| ItemStack|
 
#### 0x12 - Container Set Data Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| id| int| int|
| 2| 2| value| int| int|
 
#### 0x13 - Container Set Slot Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| stateId| int| int|
| 2| 2| slot| int| int|
| 3| 0| itemStack| ItemStack| ItemStack|
 
#### 0x14 - Cooldown Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| item| Item| Item|
| 1| 0| duration| int| int|
 
#### 0x15 - Custom Chat Completions Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| action| ClientboundCustomChatCompletionsPacket$Action| ClientboundCustomChatCompletionsPacket$Action|
| 1| 0| entries| List| List&lt;String&gt;|
 
#### 0x16 - Custom Payload Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| identifier| ResourceLocation| ResourceLocation|
| 1| 0| data| FriendlyByteBuf| FriendlyByteBuf|
 
#### 0x17 - Delete Chat Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| messageSignature| MessageSignature$Packed| MessageSignature$Packed|
 
#### 0x18 - Disconnect Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| reason| Component| Component|
 
#### 0x19 - Disguised Chat Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| message| Component| Component|
| 1| 0| chatType| ChatType$BoundNetwork| ChatType$BoundNetwork|
 
#### 0x1A - Entity Event Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| eventId| byte| byte|
 
#### 0x1B - Explode Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| power| float| float|
| 4| 0| toBlow| List| List&lt;BlockPos&gt;|
| 5| 1| knockbackX| float| float|
| 6| 2| knockbackY| float| float|
| 7| 3| knockbackZ| float| float|
 
#### 0x1C - Forget Level Chunk Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
 
#### 0x1D - Game Event Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| event| ClientboundGameEventPacket$Type| ClientboundGameEventPacket$Type|
| 1| 0| param| float| float|
 
#### 0x1E - Horse Screen Open Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 1| size| int| int|
| 2| 2| entityId| int| int|
 
#### 0x1F - Hurt Animation Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| yaw| float| float|
 
#### 0x20 - Initialize Border Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| newCenterX| double| double|
| 1| 1| newCenterZ| double| double|
| 2| 2| oldSize| double| double|
| 3| 3| newSize| double| double|
| 4| 0| lerpTime| long| long|
| 5| 0| newAbsoluteMaxSize| int| int|
| 6| 1| warningBlocks| int| int|
| 7| 2| warningTime| int| int|
 
#### 0x21 - Keep Alive Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| long| long|
 
#### 0x22 - Level Chunk With Light Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
| 2| 0| chunkData| ClientboundLevelChunkPacketData| ClientboundLevelChunkPacketData|
| 3| 0| lightData| ClientboundLightUpdatePacketData| ClientboundLightUpdatePacketData|
 
#### 0x23 - Level Event Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| type| int| int|
| 1| 0| pos| BlockPos| BlockPos|
| 2| 1| data| int| int|
| 3| 0| globalEvent| boolean| boolean|
 
#### 0x24 - Level Particles Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| xDist| float| float|
| 4| 1| yDist| float| float|
| 5| 2| zDist| float| float|
| 6| 3| maxSpeed| float| float|
| 7| 0| count| int| int|
| 8| 0| overrideLimiter| boolean| boolean|
| 9| 0| particle| ParticleOptions| ParticleOptions|
 
#### 0x25 - Light Update Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
| 2| 0| lightData| ClientboundLightUpdatePacketData| ClientboundLightUpdatePacketData|
 
#### 0x26 - Login Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| playerId| int| int|
| 1| 0| hardcore| boolean| boolean|
| 2| 0| gameType| GameType| GameType|
| 3| 1| previousGameType| GameType| GameType|
| 4| 0| levels| Set| Set&lt;ResourceKey&lt;Level&gt;&gt;|
| 5| 0| registryHolder| RegistryAccess$Frozen| RegistryAccess$Frozen|
| 6| 0| dimensionType| ResourceKey| ResourceKey&lt;DimensionType&gt;|
| 7| 1| dimension| ResourceKey| ResourceKey&lt;Level&gt;|
| 8| 0| seed| long| long|
| 9| 1| maxPlayers| int| int|
| 10| 2| chunkRadius| int| int|
| 11| 3| simulationDistance| int| int|
| 12| 1| reducedDebugInfo| boolean| boolean|
| 13| 2| showDeathScreen| boolean| boolean|
| 14| 3| isDebug| boolean| boolean|
| 15| 4| isFlat| boolean| boolean|
| 16| 0| lastDeathLocation| Optional| Optional&lt;GlobalPos&gt;|
 
#### 0x27 - Map Item Data Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| mapId| int| int|
| 1| 0| scale| byte| byte|
| 2| 0| locked| boolean| boolean|
| 3| 0| decorations| List| List&lt;MapDecoration&gt;|
| 4| 0| colorPatch| MapItemSavedData$MapPatch| MapItemSavedData$MapPatch|
 
#### 0x28 - Merchant Offers Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| offers| MerchantOffers| MerchantOffers|
| 2| 1| villagerLevel| int| int|
| 3| 2| villagerXp| int| int|
| 4| 0| showProgress| boolean| boolean|
| 5| 1| canRestock| boolean| boolean|
 
#### 0x29 - Pos (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| xa| short| short|
| 2| 1| ya| short| short|
| 3| 2| za| short| short|
| 4| 0| yRot| byte| byte|
| 5| 1| xRot| byte| byte|
| 6| 0| onGround| boolean| boolean|
| 7| 1| hasRot| boolean| boolean|
| 8| 2| hasPos| boolean| boolean|
 
#### 0x2A - Pos Rot (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| xa| short| short|
| 2| 1| ya| short| short|
| 3| 2| za| short| short|
| 4| 0| yRot| byte| byte|
| 5| 1| xRot| byte| byte|
| 6| 0| onGround| boolean| boolean|
| 7| 1| hasRot| boolean| boolean|
| 8| 2| hasPos| boolean| boolean|
 
#### 0x2B - Rot (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| xa| short| short|
| 2| 1| ya| short| short|
| 3| 2| za| short| short|
| 4| 0| yRot| byte| byte|
| 5| 1| xRot| byte| byte|
| 6| 0| onGround| boolean| boolean|
| 7| 1| hasRot| boolean| boolean|
| 8| 2| hasPos| boolean| boolean|
 
#### 0x2C - Move Vehicle Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
 
#### 0x2D - Open Book Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| hand| InteractionHand| InteractionHand|
 
#### 0x2E - Open Screen Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| type| MenuType| MenuType&lt;?&gt;|
| 2| 0| title| Component| Component|
 
#### 0x2F - Open Sign Editor Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
 
#### 0x30 - Ping Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
 
#### 0x31 - Place Ghost Recipe Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| containerId| int| int|
| 1| 0| recipe| ResourceLocation| ResourceLocation|
 
#### 0x32 - Player Abilities Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| invulnerable| boolean| boolean|
| 1| 1| isFlying| boolean| boolean|
| 2| 2| canFly| boolean| boolean|
| 3| 3| instabuild| boolean| boolean|
| 4| 0| flyingSpeed| float| float|
| 5| 1| walkingSpeed| float| float|
 
#### 0x33 - Player Chat Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sender| UUID| UUID|
| 1| 0| index| int| int|
| 2| 0| signature| MessageSignature| MessageSignature|
| 3| 0| body| SignedMessageBody$Packed| SignedMessageBody$Packed|
| 4| 0| unsignedContent| Component| Component|
| 5| 0| filterMask| FilterMask| FilterMask|
| 6| 0| chatType| ChatType$BoundNetwork| ChatType$BoundNetwork|
 
#### 0x34 - Player Combat End Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| killerId| int| int|
| 1| 1| duration| int| int|
 
#### 0x35 - Player Combat Enter Packet (S ➔ C)
Packet has no fields
 
#### 0x36 - Player Combat Kill Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| playerId| int| int|
| 1| 1| killerId| int| int|
| 2| 0| message| Component| Component|
 
#### 0x37 - Player Info Remove Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| profileIds| List| List&lt;UUID&gt;|
 
#### 0x38 - Player Info Update Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| actions| EnumSet| EnumSet&lt;ClientboundPlayerInfoUpdatePacket$Action&gt;|
| 1| 0| entries| List| List&lt;ClientboundPlayerInfoUpdatePacket$Entry&gt;|
 
#### 0x39 - Player Look At Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| entity| int| int|
| 4| 0| fromAnchor| EntityAnchorArgument$Anchor| EntityAnchorArgument$Anchor|
| 5| 1| toAnchor| EntityAnchorArgument$Anchor| EntityAnchorArgument$Anchor|
| 6| 0| atEntity| boolean| boolean|
 
#### 0x3A - Player Position Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| double| double|
| 1| 1| y| double| double|
| 2| 2| z| double| double|
| 3| 0| yRot| float| float|
| 4| 1| xRot| float| float|
| 5| 0| relativeArguments| Set| Set&lt;RelativeMovement&gt;|
| 6| 0| id| int| int|
| 7| 0| dismountVehicle| boolean| boolean|
 
#### 0x3B - Recipe Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| state| ClientboundRecipePacket$State| ClientboundRecipePacket$State|
| 1| 0| recipes| List| List&lt;ResourceLocation&gt;|
| 2| 1| toHighlight| List| List&lt;ResourceLocation&gt;|
| 3| 0| bookSettings| RecipeBookSettings| RecipeBookSettings|
 
#### 0x3C - Remove Entities Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityIds| IntList| IntList|
 
#### 0x3D - Remove Mob Effect Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| effect| MobEffect| MobEffect|
 
#### 0x3E - Resource Pack Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| url| String| String|
| 1| 1| hash| String| String|
| 2| 0| required| boolean| boolean|
| 3| 0| prompt| Component| Component|
 
#### 0x3F - Respawn Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| dimensionType| ResourceKey| ResourceKey&lt;DimensionType&gt;|
| 1| 1| dimension| ResourceKey| ResourceKey&lt;Level&gt;|
| 2| 0| seed| long| long|
| 3| 0| playerGameType| GameType| GameType|
| 4| 1| previousPlayerGameType| GameType| GameType|
| 5| 0| isDebug| boolean| boolean|
| 6| 1| isFlat| boolean| boolean|
| 7| 0| dataToKeep| byte| byte|
| 8| 0| lastDeathLocation| Optional| Optional&lt;GlobalPos&gt;|
 
#### 0x40 - Rotate Head Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| yHeadRot| byte| byte|
 
#### 0x41 - Section Blocks Update Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sectionPos| SectionPos| SectionPos|
| 1| 0| positions| short[]| short[]|
| 2| 0| states| BlockState[]| BlockState[]|
| 3| 0| suppressLightUpdates| boolean| boolean|
 
#### 0x42 - Select Advancements Tab Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tab| ResourceLocation| ResourceLocation|
 
#### 0x43 - Server Data Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| motd| Optional| Optional&lt;Component&gt;|
| 1| 1| iconBase64| Optional| Optional&lt;String&gt;|
| 2| 0| enforcesSecureChat| boolean| boolean|
 
#### 0x44 - Set Action Bar Text Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| text| Component| Component|
 
#### 0x45 - Set Border Center Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| newCenterX| double| double|
| 1| 1| newCenterZ| double| double|
 
#### 0x46 - Set Border Lerp Size Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| oldSize| double| double|
| 1| 1| newSize| double| double|
| 2| 0| lerpTime| long| long|
 
#### 0x47 - Set Border Size Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| size| double| double|
 
#### 0x48 - Set Border Warning Delay Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| warningDelay| int| int|
 
#### 0x49 - Set Border Warning Distance Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| warningBlocks| int| int|
 
#### 0x4A - Set Camera Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| cameraId| int| int|
 
#### 0x4B - Set Carried Item Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
 
#### 0x4C - Set Chunk Cache Center Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| x| int| int|
| 1| 1| z| int| int|
 
#### 0x4D - Set Chunk Cache Radius Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| radius| int| int|
 
#### 0x4E - Set Default Spawn Position Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| pos| BlockPos| BlockPos|
| 1| 0| angle| float| float|
 
#### 0x4F - Set Display Objective Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| slot| int| int|
| 1| 0| objectiveName| String| String|
 
#### 0x50 - Set Entity Data Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| packedItems| List| List&lt;SynchedEntityData$DataValue&lt;?&gt;&gt;|
 
#### 0x51 - Set Entity Link Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sourceId| int| int|
| 1| 1| destId| int| int|
 
#### 0x52 - Set Entity Motion Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 1| xa| int| int|
| 2| 2| ya| int| int|
| 3| 3| za| int| int|
 
#### 0x53 - Set Equipment Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entity| int| int|
| 1| 0| slots| List| List&lt;Pair&lt;EquipmentSlot, ItemStack&gt;&gt;|
 
#### 0x54 - Set Experience Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| experienceProgress| float| float|
| 1| 0| totalExperience| int| int|
| 2| 1| experienceLevel| int| int|
 
#### 0x55 - Set Health Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| health| float| float|
| 1| 0| food| int| int|
| 2| 1| saturation| float| float|
 
#### 0x56 - Set Objective Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| objectiveName| String| String|
| 1| 0| displayName| Component| Component|
| 2| 0| renderType| ObjectiveCriteria$RenderType| ObjectiveCriteria$RenderType|
| 3| 0| method| int| int|
 
#### 0x57 - Set Passengers Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| vehicle| int| int|
| 1| 0| passengers| int[]| int[]|
 
#### 0x58 - Set Player Team Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| method| int| int|
| 1| 0| name| String| String|
| 2| 0| players| Collection| Collection&lt;String&gt;|
| 3| 0| parameters| Optional| Optional&lt;ClientboundSetPlayerTeamPacket$Parameters&gt;|
 
#### 0x59 - Set Score Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| owner| String| String|
| 1| 1| objectiveName| String| String|
| 2| 0| score| int| int|
| 3| 0| method| ServerScoreboard$Method| ServerScoreboard$Method|
 
#### 0x5A - Set Simulation Distance Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| simulationDistance| int| int|
 
#### 0x5B - Set Subtitle Text Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| text| Component| Component|
 
#### 0x5C - Set Time Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| gameTime| long| long|
| 1| 1| dayTime| long| long|
 
#### 0x5D - Set Title Text Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| text| Component| Component|
 
#### 0x5E - Set Titles Animation Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| fadeIn| int| int|
| 1| 1| stay| int| int|
| 2| 2| fadeOut| int| int|
 
#### 0x5F - Sound Entity Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sound| Holder| Holder&lt;SoundEvent&gt;|
| 1| 0| source| SoundSource| SoundSource|
| 2| 0| id| int| int|
| 3| 0| volume| float| float|
| 4| 1| pitch| float| float|
| 5| 0| seed| long| long|
 
#### 0x60 - Sound Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| sound| Holder| Holder&lt;SoundEvent&gt;|
| 1| 0| source| SoundSource| SoundSource|
| 2| 0| x| int| int|
| 3| 1| y| int| int|
| 4| 2| z| int| int|
| 5| 0| volume| float| float|
| 6| 1| pitch| float| float|
| 7| 0| seed| long| long|
 
#### 0x61 - Stop Sound Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| name| ResourceLocation| ResourceLocation|
| 1| 0| source| SoundSource| SoundSource|
 
#### 0x62 - System Chat Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| content| Component| Component|
| 1| 0| overlay| boolean| boolean|
 
#### 0x63 - Tab List Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| header| Component| Component|
| 1| 1| footer| Component| Component|
 
#### 0x64 - Tag Query Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| tag| CompoundTag| CompoundTag|
 
#### 0x65 - Take Item Entity Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| itemId| int| int|
| 1| 1| playerId| int| int|
| 2| 2| amount| int| int|
 
#### 0x66 - Teleport Entity Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| id| int| int|
| 1| 0| x| double| double|
| 2| 1| y| double| double|
| 3| 2| z| double| double|
| 4| 0| yRot| byte| byte|
| 5| 1| xRot| byte| byte|
| 6| 0| onGround| boolean| boolean|
 
#### 0x67 - Update Advancements Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| reset| boolean| boolean|
| 1| 0| added| Map| Map&lt;ResourceLocation, Advancement$Builder&gt;|
| 2| 0| removed| Set| Set&lt;ResourceLocation&gt;|
| 3| 1| progress| Map| Map&lt;ResourceLocation, AdvancementProgress&gt;|
 
#### 0x68 - Update Attributes Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| attributes| List| List&lt;ClientboundUpdateAttributesPacket$AttributeSnapshot&gt;|
 
#### 0x69 - Update Enabled Features Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| features| Set| Set&lt;ResourceLocation&gt;|
 
#### 0x6A - Update Mob Effect Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| entityId| int| int|
| 1| 0| effect| MobEffect| MobEffect|
| 2| 0| effectAmplifier| byte| byte|
| 3| 1| effectDurationTicks| int| int|
| 4| 1| flags| byte| byte|
| 5| 0| factorData| MobEffectInstance$FactorData| MobEffectInstance$FactorData|
 
#### 0x6B - Update Recipes Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| recipes| List| List&lt;Recipe&lt;?&gt;&gt;|
 
#### 0x6C - Update Tags Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| tags| Map| Map&lt;ResourceKey&lt;? extends Registry&lt;?&gt;&gt;, TagNetworkSerialization$NetworkPayload&gt;|
 
## Status (Serverbound)
#### 0x00 - Status Request Packet (C ➔ S)
Packet has no fields
 
#### 0x01 - Ping Request Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
## Status (Clientbound)
#### 0x00 - Status Response Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| status| ServerStatus| ServerStatus|
 
#### 0x01 - Pong Response Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| time| long| long|
 
## Login (Serverbound)
#### 0x00 - Hello Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| name| String| String|
| 1| 0| profileId| Optional| Optional&lt;UUID&gt;|
 
#### 0x01 - Key Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| keybytes| byte[]| byte[]|
| 1| 1| encryptedChallenge| byte[]| byte[]|
 
#### 0x02 - Custom Query Packet (C ➔ S)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| data| FriendlyByteBuf| FriendlyByteBuf|
 
## Login (Clientbound)
#### 0x00 - Login Disconnect Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| reason| Component| Component|
 
#### 0x01 - Hello Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| serverId| String| String|
| 1| 0| publicKey| byte[]| byte[]|
| 2| 1| challenge| byte[]| byte[]|
 
#### 0x02 - Game Profile Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| gameProfile| GameProfile| GameProfile|
 
#### 0x03 - Login Compression Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| compressionThreshold| int| int|
 
#### 0x04 - Custom Query Packet (S ➔ C)
| Index | Type Index | Name | Raw Type | Full Type |
| -------------| -------------| -------------| -------------| -------------|
| 0| 0| transactionId| int| int|
| 1| 0| identifier| ResourceLocation| ResourceLocation|
| 2| 0| data| FriendlyByteBuf| FriendlyByteBuf|
 
